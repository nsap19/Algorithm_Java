package baekjoon_step16;

import java.io.*;

public class Baekjoon1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[1] = 0;

        if (n >= 2) { //모든 과정에서 +1을 해주는 것은 -1, /2, /3의 연산 횟수를 더해준 것
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + 1;
                if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
                if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        } // 모든 n에 대해서 2,3으로 나눠지지 않는 수는 -1에 대한 수의 연산 횟수에 +1해주고
        // 2나 3으로 나눠지는 수는 -1에 대한 수와 2,3으로 나눈 수를 비교하여 더 작은 연산 횟수에 +1을 더해주면 된다.

        bw.write(String.valueOf(dp[n]));
        bw.close();
    }
}
