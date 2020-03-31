package baekjoon_step16;

import java.io.*;
import java.util.Arrays;

public class Baekjoon9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr1 = br.readLine().split("");
        String[] arr2 = br.readLine().split("");
        int[][] dp = new int[arr2.length + 1][arr1.length + 1];

        for (int i = 1; i <= arr2.length; i++) {
            for (int j = 1; j <= arr1.length; j++) {
                if (arr1[j - 1].equals(arr2[i - 1]) && dp[i - 1][j - 1] + 1 > dp[i][j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

//        for (int[] v : dp) {
//            for (int a : v)
//                System.out.print(a + " ");
//            System.out.println();
//        }


        bw.write(String.valueOf(dp[arr2.length][arr1.length]));
        bw.close();
    }
}
