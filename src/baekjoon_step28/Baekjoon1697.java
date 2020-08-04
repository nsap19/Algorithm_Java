package baekjoon_step28;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1697 {
    static int n, k;
    static int[] visited = new int[100001];
    static int[] status = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //수빈이가 있는 위치
        k = Integer.parseInt(st.nextToken()); //동생이 있는 위치

        bfs();
        bw.write(String.valueOf(visited[k] - 1)); //visited가 0이 아닌 1에서 시작했기때문에 -1 해줌
        bw.close();
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;

        while (!q.isEmpty()) {
            n = q.poll();

            if (n == k) break;

            status[0] = n + 1;
            status[1] = n - 1;
            status[2] = n * 2;

            for (int i = 0; i < 3; i++) {
                if (status[i] >= 0 && status[i] <= 100000) { //상태가 범위 내에 있는지 확인
                    if (visited[status[i]] == 0) { //방문한 적이 없는지 확인
                        q.add(status[i]);
                        visited[status[i]] = visited[n] + 1;
                    }
                }
            }
        }
    }
}
