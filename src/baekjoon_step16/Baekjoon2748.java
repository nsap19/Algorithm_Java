/* 동적계획법을 이용한 피보나치 수열 구하기
 * 이전에 계산했던 수열의 항 배열에 저장해놓음
 *
 * 반복되는 계산을 막기위해 이전해 계산되었던 결과를 저정하는 문제 해결 전략을 동적 프로그래밍(Dynamic Programming) */
package baekjoon_step16;

import java.io.*;

public class Baekjoon2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] fibo = new long[n + 1];

        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i - 2] + fibo[i - 1];
        }

//        for (int i = 0; i < fibo.length; i++) {
//            System.out.print(fibo[i] + " ");
//        }

        bw.write(String.valueOf(fibo[n]));
        bw.close();

    }

}
