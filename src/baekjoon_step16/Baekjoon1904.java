/* dp[n]의 값은 dp[n-2]+ dp[n-1]의 값과 같다
* dp[n-2]의 값에서 뒤에 00을 붙이고
* dp[n-1]의 값에서 뒤에 1을 붙이면
* dp[n]에 나와야하는 경우의 수를 모두 구할 수 있다.
*
[예시]
* N = 3 일 때, 가능한 수를 보면,
* N = 1 일 때, 가능한 (1) 에다가 00 을 더한 100
* N = 2 일 때, 가능한 (11, 00) 에다가 1을 더한 111, 001
* 이렇게 3개 이다.

* N = 4 일 때도 똑같이
* N = 2 일 때, 가능한 (11, 00) 에다가 00 을 더한 1100, 0000
* N = 3 일 때, 가능한 (111, 100, 001) 에다가 1을 더한 1111, 1001, 0011
* 이렇게 5개 이다.*/

package baekjoon_step16;

import java.io.*;

public class Baekjoon1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];

        if (n == 0) dp[0] = 0;
        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
        }

//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(dp[i]);
//        }
        bw.write(String.valueOf(dp[n]));
        bw.close();

    }
}
