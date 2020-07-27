package baekjoon_step26;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon10942 {
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); //수열의 크기
        int[] arr = new int[n + 1]; //수열
        dp = new boolean[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(arr, n);

        int m = Integer.parseInt(br.readLine()); //질문의 개수

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (dp[start][end]) bw.write("1\n");
            else bw.write("0\n");
        }
        bw.close();


    }

    private static void solve(int[] arr, int n) {
        //길이가 1인 경우 : 항상 팰린드롬
        for (int i = 1; i <= n; i++)
            dp[i][i] = true;

        //길이가 2인 경우 : 2개의 수의 값이 같은 경우 펠린드롬
        for (int i = 1; i <= n - 1; i++)
            if (arr[i] == arr[i + 1]) dp[i][i + 1] = true;

        //길이가 3이상일 경우 : 시작점의 값 = 끝의 값 && (시작점 + 1) ~ (끝 - 1) 인덱스 까지 펠린드롬  이면 펠린드롬
        for (int i = 2; i <= n; i++) { //j+i는 끝
            for (int j = 1; j <= n - i; j++) { //j는 시작점
                if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1])
                    dp[j][j + i] = true;

            }
        }
    }
}
