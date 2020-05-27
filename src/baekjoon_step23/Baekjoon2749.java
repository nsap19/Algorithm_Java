/* [피사노 주기(Pisano Period)]
   피보나치 수를 K로 나눈 나머지는 항상 주기를 가지게 됨.
   주기의 길이가 P 이면, N번째 피보나치 수를 Mod으로 나눈 나머지는 N%P번째 피보나치 수를 Mod을 나눈 나머지와 같음
   M = 10^k 일 때, k > 2 라면, 주기는 항상 15 × 10^(k-1)
   이 문제에서 M = 10^6 이기 때문에, 주기는 15 × 10^5 = 1500000
 */
package baekjoon_step23;

import java.io.*;

public class Baekjoon2749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        int mod = 1000000;
        int p = mod / 10 * 15; //p는 주기
        int[] fibo = new int[p]; //주기 길이만큼 값이 반복되므로 fibo배열의 길이는 p

        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i < p; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
            fibo[i] %= mod;
        }

        long newN = n % p; //N번째 피보나치 수를 Mod으로 나눈 나머지 = N%P번째 피보나치 수를 Mod을 나눈 나머지
        int result = fibo[(int) newN];

        bw.write(String.valueOf(result));
        bw.close();
    }
}
