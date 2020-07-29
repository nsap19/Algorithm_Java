package baekjoon_step28;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon1012 {
    static int[][] arr;
    static int m, n, k;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); //테스트케이스

        for (int Testcase = 0; Testcase < t; Testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken()); //가로길이
            n = Integer.parseInt(st.nextToken()); //세로길이
            k = Integer.parseInt(st.nextToken()); //심어져있는 배추의 갯수


            arr = new int[n][m];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[y][x] = 1;
            }

            int total = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1) {
                        total++;

                        dfs(i, j);

                    }
                }
            }

            bw.write(total + "\n");
        }
        bw.close();

    }

    public static void dfs(int x, int y) {
        arr[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (arr[nx][ny] == 1) dfs(nx, ny);
            }
        }
    }

}

