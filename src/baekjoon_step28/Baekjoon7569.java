package baekjoon_step28;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7569 {
    static int m, n, h;
    static int[][][] tomato;
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<int[]> q;
    static int day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); //상자의 가로칸 수
        n = Integer.parseInt(st.nextToken()); //상자의 세로칸 수
        h = Integer.parseInt(st.nextToken()); //쌓아 올려지는 상자의 수
        tomato = new int[h][n][m];

        q = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 1) q.add(new int[]{i, j, k, 0}); //day를 큐에 함께 넘겨주는 것이 관건!
                }
            }
        }

        bfs();

        if (checkTomato()) bw.write(String.valueOf(day));
        else bw.write(String.valueOf(-1));
        bw.close();
    }

    public static void bfs() {
        day = 0;

        while (!q.isEmpty()) {
            int[] location = q.poll();
            day = location[3];

            for (int k = 0; k < 6; k++) {
                int newH = location[0] + dz[k];
                int newN = location[1] + dy[k];
                int newM = location[2] + dx[k];

                if (newH >= 0 && newH < h && newN >= 0 && newN < n && newM >= 0 && newM < m) {
                    if (tomato[newH][newN][newM] == 0) {
                        q.offer(new int[]{newH, newN, newM, day + 1}); //day를 +1하여 큐에 함께 넘겨주는 것이 관건!
                        tomato[newH][newN][newM] = 1;
                    }
                }
            }
        }
    }

    public static boolean checkTomato() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomato[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }
}
