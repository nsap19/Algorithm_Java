package baekjoon_gold;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int end;
    int value;

    public Node(int end, int value) {
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}

public class Baekjoon1197 {
    static int V, E;
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

//        첫째 줄에 정점의 개수 V(1 ≤ V ≤ 10,000)와 간선의 개수 E(1 ≤ E ≤ 100,000)가 주어진다.
//        다음 E개의 줄에는 각 간선에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
//        이는 A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다는 의미이다. C는 음수일 수도 있으며, 절댓값이 1,000,000을 넘지 않는다.
//
//                그래프의 정점은 1번부터 V번까지 번호가 매겨져 있고, 임의의 두 정점 사이에 경로가 있다. 최소 스패닝 트리의 가중치가 -2,147,483,648보다 크거나 같고, 2,147,483,647보다 작거나 같은 데이터만 입력으로 주어진다.
        st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[V + 1];
        dist = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        Arrays.fill(dist, Integer.MAX_VALUE);

        int result = prim();

        System.out.println(result);
    }


    private static int prim() {
        int result = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));
        dist[1] = 0; //임의의 시작점 1

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cur = node.end;
//            System.out.println("cur:"+cur+" "+node.value);
            if (visited[cur]) continue;
            visited[cur] = true;
            result += node.value;

            for (Node next : list[cur]) {
                if (dist[next.end] > next.value) {
                    dist[next.end] = next.value;
                    queue.add(new Node(next.end, dist[next.end]));
//                    System.out.println(next.end+" "+dist[next.end]);
                }
            }
        }
        return result;
    }
}
