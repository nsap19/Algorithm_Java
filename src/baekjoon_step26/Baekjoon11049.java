package baekjoon_step26;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][2];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][j + i] = Integer.MAX_VALUE;
                for (int k = 0; k < i; k++) {
                    int cost = dp[j][j + k] + dp[j + k + 1][j + i] + a[j][0] * a[j + k][1] * a[j + i][1];
//                    System.out.println("cost : dp["+j+"]["+(j+k)+"] + dp["+(j+k+1)+"]["+(j+i)+"] + a["+j+"][0] * a["+(j+k)+"][1] * a["+(j+i)+"][1]");
//                    System.out.println("= "+dp[j][j + k]+" + "+ dp[j + k + 1][j + i] +" + "+ a[j][0] +" * "+ a[j + k][1] +" * "+ a[j + i][1]);
//                    System.out.println(i+" "+j+" "+k);
//                    System.out.println(cost+" "+dp[j][j+1]);
                    dp[j][j + i] = Math.min(dp[j][j + i], cost);
                }
            }
        }
        bw.write(dp[0][n - 1] + "\n");

        bw.close();
    }
}
