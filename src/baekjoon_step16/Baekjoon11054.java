//1 5 2 1 4 3 4 5 2 1
//앞에서부터 커지는 숫자에 대한 LIS를 구하고 (dp1) ex)1,2,3,4,5
//뒤에서부터 커지는 숫자에 대한 LIS를 구한 후 (dp2) ex) 5,2,1
//그 두 값들을 더해서 가장 큰 값을 구하면 됌(중복되는 횟수 1을 빼야함)


package baekjoon_step16;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //앞에서부터 시작하는 LIS
        for (int i = 0; i < n; i++) {
            dp1[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (arr[i] > arr[j] && dp1[j] + 1 > dp1[i]) {
                    dp1[i] = dp1[j] + 1;
                }
            }
        }

        //뒤에서부터 시작하는 LIS
        for (int i = n - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = n - 1; j >= i; j--) {
                if (arr[i] > arr[j] && dp2[j] + 1 > dp2[i]) {
                    dp2[i] = dp2[j] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            dp2[i] += dp1[i];
        }

        Arrays.sort(dp2);
        bw.write(String.valueOf(dp2[n-1]-1));
        bw.close();

    }
}
