// dp[i][j] = (i자리 숫자이면서 j로 끝나는 수의 개수)

package baekjoon_step16;

import java.io.*;

public class Baekjoon10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j <= 9; j++) {
                    if (j == 0) dp[i][j] = dp[i - 1][1] % 1000000000;
                    else if (j == 9) dp[i][j] = (dp[i - 1][8]) % 1000000000;
                    else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i];
        }
        sum %= 1000000000;

        bw.write(String.valueOf(sum));
        bw.close();
    }
}
