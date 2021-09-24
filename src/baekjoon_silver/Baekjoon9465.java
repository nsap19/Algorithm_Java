package baekjoon_silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon9465 {
    static int N, max;
    static int[][] arr, dp;
    static boolean[][] visited;

    //첨엔 백트래킹으로 시작했지만 막혔고, 하다보니 규칙이 있는것같아서 DP로 변경
    //다른 풀이를 찾아보니 1번열부터 저장해서 시작하면 N의 크기를 확인하는 조건문을 하나만 사용할 수 있었음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[2][N];
            visited = new boolean[2][N];
            dp = new int[2][N];
            max = 0;

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            if (N > 1) {
                dp[0][1] = arr[1][0] + arr[0][1];
                dp[1][1] = arr[0][0] + arr[1][1];

                if (N > 2) {
                    for (int i = 2; i < N; i++) {
                        dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
                        dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
                    }
                }
            }

            max = Math.max(dp[0][N - 1], dp[1][N - 1]);

            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }

}
