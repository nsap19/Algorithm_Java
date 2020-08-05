//참고 - https://dragon-h.tistory.com/20
package baekjoon_step29;

import java.io.*;
import java.util.*;

public class Baekjoon1753 {
    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) { //우선순위큐(PriorityQueue)에서 가중치 오름차순으로 정렬
            return weight - o.weight;
        }

        @Override
        public String toString() {
            return "end=" + end +
                    ", weight=" + weight;
        }
    }

    static int v, e, k;
    static List<Node>[] list;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        dist = new int[v + 1];

        Arrays.fill(dist, INF);

        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }

        dijkstra(k);

        for (int i = 1; i <= v; i++) {
            if (dist[i] == INF) bw.write("INF\n");
            else bw.write(dist[i] + "\n");
        }

        bw.close();
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>(); //dist배열 중 최솟값을 가지는 노드를 구하기 위해 우선순위 큐를 이용
        boolean[] visit = new boolean[v + 1]; //각 점들의 방문 여부

        queue.add(new Node(start, 0));
        dist[start] = 0; //시작점 자신은 0으로 출력하라고 문제에 명시

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int current = currentNode.end;

//            System.out.println("current : "+current);

            if (visit[current]) continue; //가중치 우선순위 큐에서 poll한 값이기 때문에 방문한 노드는 계산하지 않아도 됌
            visit[current] = true;

            for (Node nextNode : list[current]) { //currentNode에 연결된 node들의 가중치 비교
                // (연결된 노드의 기존 값 vs currentNode의 가중치 + 연결된 노드 가중치)

//                System.out.println(nextNode);
//                System.out.println(dist[nextNode.end]+" vs "+ dist[current]+" + "+nextNode.weight);

                if (dist[nextNode.end] > dist[current] + nextNode.weight) {
                    dist[nextNode.end] = dist[current] + nextNode.weight;
                    queue.add(new Node(nextNode.end, dist[nextNode.end]));
//                    System.out.println("end="+nextNode.end+", weight="+dist[nextNode.end]);
//                    System.out.println();
                }
            }
        }


    }
}
