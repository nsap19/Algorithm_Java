package baekjoon_step16;

import java.io.*;

public class Baekjoon9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr1 = br.readLine().split("");
        String[] arr2 = br.readLine().split("");
        int[] dp = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            dp[i] = 1;
            for (int j = 0; j <arr2.length; j++) {
                if (arr[i] > arr[j] && dp1[j] + 1 > dp1[i]) {
                    dp1[i] = dp1[j] + 1;
                }
            }
        }

    }
}
