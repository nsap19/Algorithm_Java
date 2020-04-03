package baekjoon_step16;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = arr[i];
            for (int j = i - 1; j < i; j++) {
                if (dp[j] + dp[i] > dp[i]) {
                    dp[i] += dp[j];
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.print(dp[i]+" ");
//        }
//        System.out.println();

        Arrays.sort(dp);
        bw.write(String.valueOf(dp[n - 1]));
        bw.close();
    }
}
