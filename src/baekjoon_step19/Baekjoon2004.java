// nCm = n! / (n-m)! * m!
//실제로 조합을 풀라는게 아니라 n!/(n-r)!r!을 계산한 것에서 10의배수 즉 5와 2의 배수의 갯수를 찾는것
// 5의배수의 개수와 2의 배수의 갯수중 작은것이 답

package baekjoon_step19;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon2004 {
    private static long five_count = 0;
    private static long two_count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        five_count = five_count(n);
        two_count = two_count(n);

        five_count -= five_count(n - m);
        five_count -= five_count(m);
        two_count -= two_count(n - m);
        two_count -= two_count(m);

        bw.write(String.valueOf(five_count >= two_count ? two_count : five_count));
        bw.close();
    }

    static long two_count(long n) {
        long count = 0;

        for (long i = 2; i <= n; i *= 2) {
            count += n / i;
        }
        return count;
    }

    static long five_count(long n) {
        long count = 0;
        for (long i = 5; i <= n; i *= 5) {
            count += n / i;
        }
        return count;
    }
}
