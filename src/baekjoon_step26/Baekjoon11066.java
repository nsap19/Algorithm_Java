package baekjoon_step26;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); //테스트케이스

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int[] file = new int[k];
            int[] dp = new int[k+1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < k ; j++) {
                file[j] = Integer.parseInt(st.nextToken());
            }

            dp[0] = 0;
            dp[1] = file[1];

            for (int j = 2; j < k ; j++) {

            }

        }

    }
}
