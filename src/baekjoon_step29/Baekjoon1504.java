/* 이전단계인 1753 (최단경로 - 다익스트라 기본 문제)와 비슷하지만, 범위만 나눠서 풀면 유사하게 풀 수 있는 문제
* 양방향이고, 1 -> N 까지 두 개의 주어진 정점을 지나면서 가는 최단거리를 구하는 문제
* 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다.
*
* 1. 1 -> v1 -> v2 -> N으로 가는 최단거리
* 2. 1 -> v2 -> v1 -> N으로 가는 최단거리

* 1 경우는  1 -> v1 최단거리, v1 -> v2 최단거리, v2 -> N의 최단거리를 각각 다익스트라를 통해 구한 뒤 더해준다.
* 2 경우는  1 -> v2 최단거리, v2 -> v1 최단거리, v1 -> N의 최단거리를 각각 다익스트라를 통해 구한 뒤 더해준다.
* [참고 - https://dragon-h.tistory.com/21]
* */
package baekjoon_step29;

import java.io.*;
import java.util.*;

public class Baekjoon1504 {
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

    static int n, e;
    static int v1, v2;
    static List<Node>[] list;
    static int[] dist;
    static int INF = 200_000_000; //0 ≤ 간선의 갯수 ≤ 200,000 * 1 ≤ 거리 ≤ 1,000 => 최대 200_000_000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        dist = new int[n + 1];

        Arrays.fill(dist, INF);

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            //양방향이므로 두개의 노드에 추가
            list[start].add(new Node(end, distance));
            list[end].add(new Node(start, distance));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int result = solve();
        bw.write(String.valueOf(result));
        bw.close();
    }

    public static int solve() {
        int result1 = 0;
        int result2 = 0;

        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, n);
//        System.out.println();

        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, n);

//        System.out.println(result1);
//        System.out.println(result2);

        if (result1 >= INF && result2 >= INF) return -1;
        else return Math.min(result1, result2);
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visit = new boolean[n + 1]; //각 점들의 방문 여부

        Arrays.fill(dist, INF);
        Arrays.fill(visit, false);

        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentNode = current.end;

            if (visit[currentNode]) continue;
            visit[currentNode] = true;

            for (Node next : list[currentNode]) { //currentNode에 연결된 node들의 가중치 비교
                int nextNode = next.end;
                int nextWeight = next.dis;
                // (연결된 노드의 기존 값 vs currentNode의 가중치 + 연결된 노드 가중치)
                if (dist[nextNode] > dist[currentNode] + nextWeight) {
                    dist[nextNode] = dist[currentNode] + nextWeight;
                    queue.add(new Node(nextNode, dist[nextNode]));
                }
            }
        }
//        System.out.println(start+" - "+end+" : "+dist[end]);
        return dist[end];
    }
}
