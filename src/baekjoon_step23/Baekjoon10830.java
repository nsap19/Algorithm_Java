/* 백준 1629-곱셈 문제와 비슷한 해결방식
    제곱해야할 수(b)를 2로 나누어
        짝수일 때 a^(b/2) * a^(b/2) = a^b를 구하고
        홀수일 때 a^(b/2) * a^(b/2) * a = a^(b+1)을 구한다
* */
package baekjoon_step23;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon10830 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int[][] result = divide(n, b, a);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] %= 1000;
                bw.write(String.valueOf(result[i][j] + " "));
            }
            bw.write("\n");
        }
        bw.close();
    }

    private static int[][] mul(int n, int[][] a1, int[][] a2) { //n:배열크기, a1,a2:곱해야할 배열, result:리턴해야할 결과 배열
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += a1[i][k] * a2[k][j];
                }
                result[i][j] %= 1000;
            }
        }
        return result;
    }

    private static int[][] divide(int n, long b, int[][] a) { //n:배열크기, b:제곱수, a:곱해야 할 배열
        if (b == 1) return a;
        else if (b == 2) return mul(n, a, a);
        else {
            int[][] temp = divide(n, b / 2, a);
            if (b % 2 == 0) return mul(n, temp, temp);
            else return mul(n, a, mul(n, temp, temp));
        }
    }

}
