package baekjoon_step28;

import java.io.*;
import java.util.*;

public class Baekjoon1260 {
    public static int n;
    public static LinkedList<Integer>[] nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //정점의 개수
        int m = Integer.parseInt(st.nextToken()); //간선의 개수
        int v = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점의 번호
        nodeList = new LinkedList[n+1];

        for (int i = 0; i <= n; i++) {
            nodeList[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            nodeList[node1].add(node2);
            nodeList[node2].add(node1);

            Collections.sort(nodeList[node1]);
            Collections.sort(nodeList[node2]);
        }

        StringBuilder dfsResult = new StringBuilder();
        StringBuilder bfsResult = new StringBuilder();

        boolean[] dfsVisited = new boolean[n + 1];
        boolean[] bfsVisited = new boolean[n + 1];

        dfs(v, dfsVisited, dfsResult);
        bfs(v, bfsVisited, bfsResult);

        bw.write(dfsResult + "\n" + bfsResult);
        bw.close();

    }

    public static void dfs(int node, boolean[] visited, StringBuilder sb) {
        if (visited[node]) return;

        visited[node] = true;
        sb.append(node + " ");
        for (int nextNode : nodeList[node]) {
            dfs(nextNode, visited, sb);
        }
    }

    public static void bfs(int node, boolean[] visited, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(node);

        while (!queue.isEmpty()) {
            node = queue.poll();
            if (visited[node]) continue;

            visited[node] = true;
            sb.append(node + " ");

            for (int nextNode : nodeList[node]) {
                queue.add(nextNode);
            }
        }
    }
}

