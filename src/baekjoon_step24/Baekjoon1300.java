/* 임의의 숫자(mid)를 골라 k번째 수인지 확인 => mid의 앞에 몇개의 숫자가 있는지를 확인해야함
 * A[i][j]에서 i행에 있는 숫자들은 i*j이므로 이 수의 갯수는 모두 i의 배수.
 * 그러므로 min(mid/i, N)이 i번째 행에서 mid보다 작은 숫자들의 개수가 된다.
 * (N = 1000인 경우, 첫 mid가 1000*1000/2 = 50만이 되는데, 50만/i가 N을 넘어갈 수 있으므로 min(mid/i, N)을 해준다.)수
 *
 * mid/i를 해주는 이유 :
 * i행의 숫자들은 i*1, i*2, i*3, ..., i*N으로 구성되어 있다.
 * i행의 숫자들 중 m보다 작거나 같은 숫자는 (i*j <= mid)를 만족하는 j의 개수이고
 * 이는 i * (1 ~ j) 이므로, mid/i와 같은 값이 된다.
 */
package baekjoon_step24;

import java.io.*;

public class Baekjoon1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int left = 1;
        int right = k;
        int result = 0;

        while (left <= right) {
            long count = 0;
            int mid = (left + right) / 2;

            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }

            if (count < k) left = mid + 1;
            else {
                result = mid;
                right = mid - 1;
            }
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}
