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
        int[] weight = new int[n];
        int[] value = new int[n];
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }




        for (int i = 0; i <dp.length; i++) {
                System.out.println(dp[i][0]+" "+dp[i][1]);
        }

        int temp = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0] <= k && dp[i][1] >= temp) temp = dp[i][1];
        }
        bw.write(String.valueOf(temp));
        bw.close();


    }
}
