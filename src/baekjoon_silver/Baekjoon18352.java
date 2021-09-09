package baekjoon_silver;

import java.io.*;
import java.util.*;

/**
 * 문제
 * 어떤 나라에는 1번부터 N번까지의 도시와 M개의 단방향 도로가 존재한다. 모든 도로의 거리는 1이다.
 * 이 때 특정한 도시 X로부터 출발하여 도달할 수 있는 모든 도시 중에서, 최단 거리가 정확히 K인 모든 도시들의 번호를 출력하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X가 주어진다.
 * (2 ≤ N ≤ 300,000, 1 ≤ M ≤ 1,000,000, 1 ≤ K ≤ 300,000, 1 ≤ X ≤ N)
 * 둘째 줄부터 M개의 줄에 걸쳐서 두 개의 자연수 A, B가 공백을 기준으로 구분되어 주어진다.
 * 이는 A번 도시에서 B번 도시로 이동하는 단방향 도로가 존재한다는 의미다. (1 ≤ A, B ≤ N) 단, A와 B는 서로 다른 자연수이다.
 * <p>
 * 출력
 * X로부터 출발하여 도달할 수 있는 도시 중에서, 최단 거리가 K인 모든 도시의 번호를 한 줄에 하나씩 오름차순으로 출력한다.
 * 이 때 도달할 수 있는 도시 중에서, 최단 거리가 K인 도시가 하나도 존재하지 않으면 -1을 출력한다.
 */
class Node2 implements Comparable<Node2> {
    int city;
    int distance;

    public Node2(int city, int distance) {
        this.city = city;
        this.distance = distance;
    }


    @Override
    public int compareTo(Node2 o) {
        return this.distance - o.distance;
    }
}

public class Baekjoon18352 {
    static int K, cnt = 0;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //도시의 갯수
        int M = Integer.parseInt(st.nextToken()); //도로의 갯수
        K = Integer.parseInt(st.nextToken()); //최단거리가 정확이 k인 도시를 찾아야함
        int X = Integer.parseInt(st.nextToken()); //출발도시

        visited = new boolean[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
        }

        getMinLength(X);

        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                cnt++;
            }
        }
        if (cnt == 0) System.out.println(-1);
    }

    private static void getMinLength(int start) {
        PriorityQueue<Node2> pq = new PriorityQueue<>();
        pq.add(new Node2(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node2 Node = pq.poll();
            int city = Node.city;

            for (int next : list[city]) {
                if (visited[next]) continue;
                visited[next] = true;

                if (distance[next] > distance[city] + 1) {
                    distance[next] = distance[city] + 1;
                    pq.add(new Node2(next, distance[next]));
                }
            }
        }

    }
}
