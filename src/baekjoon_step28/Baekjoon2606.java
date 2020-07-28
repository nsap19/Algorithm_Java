/* 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
 => 1번 컴퓨터와 연결되어있는 컴퓨터의 수를 찾아야하므로 bfs방식으로 검색 */
package baekjoon_step28;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2606 {
    static LinkedList<Integer>[] nodeList;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int v = Integer.parseInt(br.readLine()); //정점
        int e = Integer.parseInt(br.readLine()); //간선

        nodeList = new LinkedList[v + 1];

        for (int i = 0; i <= v; i++) {
            nodeList[i] = new LinkedList<>();
        }

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            nodeList[node1].add(node2);
            nodeList[node2].add(node1);

            Collections.sort(nodeList[node1]);
            Collections.sort(nodeList[node2]);
        }

        result = 0;
        boolean[] bfsVisited = new boolean[v + 1];
        bfs(1, bfsVisited);

        bw.write(String.valueOf(result));
        bw.close();


    }

    public static void bfs(int node, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(node);

        while (!queue.isEmpty()) {
            node = queue.poll();
            if (visited[node]) continue;

            visited[node] = true;
            if (node != 1) result++; //1번컴퓨터를 통해 바이러스감영된 컴퓨터를 세야하므로 1번 컴퓨터는 count에서 제외

            for (int nextNode : nodeList[node]) {
                queue.add(nextNode);
            }
        }
    }
}
