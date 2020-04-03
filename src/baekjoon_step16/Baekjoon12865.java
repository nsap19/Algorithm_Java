package baekjoon_step16;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) { //item
            for (int j = 1; j <= k; j++) { //weight
                dp[i][j] = dp[i - 1][j];
                if (j - weight[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

//        for (int i = 1; i <dp.length ; i++) {
//            for (int j = 1; j < dp[i].length; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

        int temp = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i][k] >= temp) temp = dp[i][k];
        }

        bw.write(String.valueOf(temp));
        bw.close();


    }
}
