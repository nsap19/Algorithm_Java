package baekjoon_step26;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11066 {
    static final int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); //테스트케이스

        for (int test = 0; test < t; test++) {
            int k = Integer.parseInt(br.readLine());
            int[] file = new int[k + 1];
            int[] sum = new int[k + 1];
            int[][] dp = new int[502][502];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= k; i++) {
                file[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + file[i];
            }

            for (int i = 2; i <= k; i++) {
                for (int j = i - 1; j > 0; j--) {
                    dp[j][i] = max;
                    for (int s = j; s <= i; s++) {
                        dp[j][i] = Math.min(dp[j][i], dp[j][s] + dp[s + 1][i]);
//                        System.out.println("dp["+j+"]["+i+"] = "+dp[j][i]);
                    }
                    dp[j][i] += sum[i] - sum[j - 1];
//                    System.out.println("+ dp["+j+"]["+i+"] = "+dp[j][i]);

                }
            }

            bw.write(String.valueOf(dp[1][k]) + "\n");
        }
        bw.close();
    }
}
