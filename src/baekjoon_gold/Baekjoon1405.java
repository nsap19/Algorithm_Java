package baekjoon_gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1405 {
    static int n, range;
    static double result = 0, val[] = new double[4];
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1}, dc = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        range = n * 2 + 1;
        for (int i = 0; i < 4; i++) {
            val[i] = Double.parseDouble(st.nextToken()) * 0.01;
        }


        visited = new boolean[range][range];
        visited[n][n] = true;
        dfs(0, range / 2, range / 2, 1.0);
        System.out.println(result);

    }

    private static void dfs(int cnt, int r, int c, double per) {
        if (cnt == n) {
            result += per;
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (nr < 0 || nr >= range || nc < 0 || nc >= range) continue;
            if (visited[nr][nc]) continue;
            visited[nr][nc] = true;
            dfs(cnt + 1, nr, nc, per * val[dir]);
            visited[nr][nc] = false;
        }
    }
}