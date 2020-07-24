package baekjoon_step26;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon1520 {
    static int m;
    static int n;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); //세로
        n = Integer.parseInt(st.nextToken()); //가로
        map = new int[m][n];
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        bw.write(String.valueOf(dfs(0, 0)));
        bw.close();
    }

    private static int dfs(int x, int y) {
        if (x == m - 1 && y == n - 1) return 1; // 도착지점에 도달하면 경로의 수 1을 리턴

        if (dp[x][y] == -1) { // 경로의 수가 계산된 적 없고, 방문한 적 없는 경우만 계산
            dp[x][y] = 0;

            //위로 이동
            if (x > 0 && map[x][y] > map[x - 1][y]) dp[x][y] += dfs(x - 1, y);

            //아래로 이동
            if (x < m - 1 && map[x][y] > map[x + 1][y]) dp[x][y] += dfs(x + 1, y);

            //왼쪽으로 이동
            if (y > 0 && map[x][y] > map[x][y - 1]) dp[x][y] += dfs(x, y - 1);

            //오른쪽으로 이동
            if (y < n - 1 && map[x][y] > map[x][y + 1]) dp[x][y] += dfs(x, y + 1);
        }

        return dp[x][y]; // 이미 와봤던 경로라면 계산된 경로의 수를 return
    }
}
