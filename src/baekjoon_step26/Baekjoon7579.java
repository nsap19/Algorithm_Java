/*  0  1  2  3  4
  ------------------
    30 10 20 35 40
    3  0  3  5  4 입력이 들어 왔을 때

dp[i][j]를 선언하고 dp[][] 의 값에는 확보가능한 최대 메모리 크기를 저장한다.
 i → 몇번째까지 입력된 앱에대한 계산인지를 뜻한다.
 j → 비용을 뜻한다.

위의 의미를 정리하면,
dp[0][0] = 0 → 0번째까지 입력된 앱을 사용할 때 비용0으로 확보가능한 최대 메모리 크기는 0
dp[0][1] = 0 → 0번째까지 입력된 앱을 사용할 때 비용1으로 확보가능한 최대 메모리 크기는 0
dp[0][3] = 30 → 0번째까지 입력된 앱을 사용할 때 비용3으로 확보가능한 최대 메모리 크기는 30

dp[1][0] = 10 → 1번째까지 입력된 앱을 사용할 때 비용0으로 확보가능한 최대 메모리 크기는 10
dp[1][3] = 40 → 1번째까지 입력된 앱을 사용할 때 비용3으로 확보가능한 최대 메모리 크기는 40

최대 메모리 크기는 dp[i][j] = max(dp[i - 1][j - cost] + memory, dp[i - 1][j]) 와 같은 방식으로 구할수 있다.
(cost : i번째 앱의 비활성화 비용, memory : i번쨰 앱의 메모리 크기)
* */
package baekjoon_step26;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //앱의 갯수
        int m = Integer.parseInt(st.nextToken()); //확보해야하는 메모리
        int result = Integer.MAX_VALUE;

        int[] memoryArr = new int[n];
        int[] costArr = new int[n];
        int[][] dp = new int[n][10000 + 1]; //최대 비용 = 10000 (n 최대 100, c 최대 100)

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            memoryArr[i] = Integer.parseInt(st1.nextToken());
            costArr[i] = Integer.parseInt(st2.nextToken());
        }

        // dp[i][j]를 선언하고 dp[][] 의 값에는 확보가능한 최대 메모리 크기를 저장
        // i → 몇번째까지 입력된 앱에대한 계산인지를 뜻한다.
        // j → 비용을 뜻한다.
        for (int i = 0; i < n; i++) {
            int memory = memoryArr[i];
            int cost = costArr[i];

            for (int j = 0; j <= 10000; j++) { //비용의 최대값인 10000까지 반복
                //앱이 하나일 경우 예외 처리
                if (i == 0) {
                    if (j >= cost) dp[i][j] = memory;
                } else {
                    if (j >= cost) dp[i][j] = Math.max(dp[i - 1][j - cost] + memory, dp[i - 1][j]);
                    else dp[i][j] = dp[i - 1][j];
                }

                // 문제에서 주어진 필요한 메모리(m)보다 확보가능한 메모리(dp[i][j])가 클 경우 정답으로 저장
                if (dp[i][j] >= m) result = Math.min(result, j);
            }
        }

        //필요한 메모리 M 바이트를 확보하기 위한 앱 비활성화의 최소의 비용을 계산하여 한 줄에 출력해야 한다.
        bw.write(String.valueOf(result));
        bw.close();


    }
}
