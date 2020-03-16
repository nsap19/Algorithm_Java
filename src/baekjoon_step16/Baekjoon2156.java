package baekjoon_step16;

import java.io.*;

public class Baekjoon2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int[] total = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = Integer.parseInt(br.readLine());
        }

        total[0] = dp[0];
        if(n > 1) total[1] = Math.max(dp[1], dp[0]+dp[1]);
        if(n > 2) total[2] = Math.max(dp[0]+dp[2],dp[1]+dp[2]);

        for (int i = 3; i < n; i++) {
            total[i] = Math.max(total[i-2]+dp[i], total[i-3]+dp[i-1]+dp[i]);
            total[i] = Math.max(total[i], total[i-1]);
            System.out.println(total[i]+" j");
        }

//        for (int i = 0; i < n; i++) {
//            System.out.print(total[i]+" ");
//        }
//        System.out.println();
        bw.write(String.valueOf(total[n-1]));
        bw.close();


    }
}
