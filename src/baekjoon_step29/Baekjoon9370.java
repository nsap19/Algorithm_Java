/* 가중치를 arr에 저장할 떄 예술가들이 지나간 교차로(필수적으로 지나가야하는 정점)간의 간선은 2를 곱하고 -1을 해주어 홀수를 만들고
나머지 간선들은 2를 곱해서 짝수를 만들어준다.

위와 같이 가중치를 저장하고 1 -> 목적지 후보까지의 최단거리를 다익스트라를 통해 구한다면
만약 최단거리가 홀수라면 주황색 간선을 지나고 온다는 뜻이 되고, 최단거리가 짝수라면 주황색 간선을 지나지 않는다는 뜻이된다.
왜냐하면, '(짝수 + 짝수 ... + 짝수) + 홀수 = 홀수' 이고 '(짝수 + 짝수 ... + 짝수) = 짝수' 이기 때문이다.
또한 이처럼 풀이하게 되면 최단거리가 같은 경우도 따로 생각하지 않고 구할 수 있다.
* */
package baekjoon_step29;

import java.io.*;
import java.util.*;

public class Baekjoon9370 {
    static class Node implements Comparable<Node> {
        int end, dis;

        public Node(int end, int dis) {
            this.end = end;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return dis - o.dis;
        }
    }

    private static final int INF = 10_000_000;
    static int vertex, edge, t;
    static int start, g, h;
    static int[][] arr; //그래프의 정보를 담는 배열
    static int[] dist;
    static boolean[] visit; //방문 여부를 담는 배열
    static List<Integer> answerList; //목적지 후보를 담는 list

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            vertex = Integer.parseInt(st.nextToken()); //교차로, 정점
            edge = Integer.parseInt(st.nextToken()); //도로, 간선
            t = Integer.parseInt(st.nextToken()); //목적지 후보 갯수

            //그래프 배열 선언
            arr = new int[vertex + 1][vertex + 1];
            dist = new int[vertex + 1];
            for (int i = 0; i < arr.length; i++) {
                Arrays.fill(arr[i], INF);
            }
            Arrays.fill(dist, INF);
            visit = new boolean[vertex + 1];

            //start,g,h 초기화
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken()); //예술가들의 출발지
            g = Integer.parseInt(st.nextToken()); //예술가들이 지나간 교차로 1
            h = Integer.parseInt(st.nextToken()); //예술가들이 지나간 교차로 2

            //그래프 정보 저장
            for (int i = 0; i < edge; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int distance = Integer.parseInt(st.nextToken());

                //2배의 가중치를 저장
                arr[v1][v2] = arr[v2][v1] = distance * 2;
            }

            //필수적으로 지나야하는 교차로의 거리에는 2배 해준 값에 -1을 하여 홀수로 만듦
            arr[h][g] = arr[g][h] = arr[h][g] - 1;

            //후보 List 선언 및 초기화
            answerList = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                answerList.add(Integer.parseInt(br.readLine()));
            }

            dijkstra();

            //입력에서 주어진 목적지 후보들 중 불가능한 경우들을 제외한 목적지들을 공백으로 분리시킨 오름차순의 정수들로 출력하기 위해서 sort
            Collections.sort(answerList);
            for (int num : answerList) {
                if (dist[num] % 2 == 1) bw.write(num + " ");
            }
            bw.write("\n");
        }

        bw.close();
    }

    public static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int current = currentNode.end;

            if (visit[current]) continue;
            visit[current] = true;

//            System.out.println("current : "+current+" ");
            for (int i = 1; i <= vertex; i++) {
//                System.out.println("i : "+i);
//                System.out.println(dist[i]+" vs "+ (dist[current] + arr[current][i]));

                if (visit[i] == false && dist[i] > dist[current] + arr[current][i]) {
                    dist[i] = dist[current] + arr[current][i];
                    queue.add(new Node(i, dist[i]));
                }
            }
//            System.out.println(Arrays.toString(dist));
//            System.out.println();
        }
    }
}
