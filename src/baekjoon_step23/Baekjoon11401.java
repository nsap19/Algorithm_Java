/* [페르마의 소정리]
    a^(p-1) % p = 1
    (a/b) % M = ((a % M) * (b^-1 % M)) = ((a % M) * (b^(M-2) % M))
*/
package baekjoon_step23;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11401 {
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long a = factorial(n);
        long b = factorial(n - k) * factorial(k) % MOD;
        long result = a * pow(b, MOD - 2) % MOD;
        bw.write(String.valueOf(result));
        bw.close();
    }

    public static long factorial(long n) {
        long result = 1;
        while (n > 1) {
            result = (result * n) % MOD;
            n--;
        }
        return result;
    }

    public static long pow(long a, int b) {
        long result = 1;
        long temp = a;

        while (b > 0) {
            if (b % 2 == 1) result = result * temp % MOD;
            b = b / 2;
            temp = (temp * temp) % MOD;
        }

        return result;
    }
}
