/* a^6 = (a^3)^2
   a^7 = (a^3)^2 * a
    따라서
    pow(a,n)은
     - 1 [n=0 일 때]
     - pow(a,n/2)^2 [n이 짝수 일 때]
     - pow(a,n/2)^2 * a [n이 홀수 일 때]
* */
package baekjoon_step23;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long result = pow(a, b, c);
        bw.write(String.valueOf(result));
        bw.close();
    }

    private static long pow(int a, int b, int c) {
        if (b == 0) return 1;

        long n = pow(a, b / 2, c);
        long temp = n * n % c;

        if (b % 2 == 0) return temp;
        else return temp * a % c;
    }
}
