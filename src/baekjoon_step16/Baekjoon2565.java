//입력받은 arr[][]에서 arr[i][0]번째 배열들을 오름차순으로 정렬하고, arr[i][1]에서 LIS를 구한 후 전체 길이에서 빼주면 된다.
//전깃줄이 꼬이지 않을 조건은 A를 기준으로 정렬했을 때 B가 순차적으로 오름차순이면 되기 때문
//주어진 예제에서 A를 기준으로 정렬하면 LIS는 [2,4,6,7,10] 또는 [1,4,6,7,10]으로 길이가 5이고, 8-5 = 3
/*
1 8
2 2
3 9
4 1
6 4
7 6
9 7
10 10
*/

package baekjoon_step16;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(o1 -> o1[0]));

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (arr[i][1] > arr[j][1] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(dp[i]+" ");
        }
        System.out.println();

        Arrays.sort(dp);
        bw.write(String.valueOf(n - dp[n - 1]));
        bw.close();

    }
}
