/* 소수 찾기

1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
(1은 소수가 아닙니다.)

제한 조건
n은 2이상 1000000이하의 자연수입니다.
*/

package etc.programmers_Lv1;

import java.io.*;

public class Programmers_Lv1_16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(solution(n)));
        bw.close();
    }

    public static int solution(int n) {
        int answer = 0;

        boolean[] nums = new boolean[n + 1];
        //초기값은 전체 false, 소수의 배수는 모두 true처리 할것임
        int temp = 0; //배수를 돌릴 기준
        //ex) 1~120이면 11*11 >120이기 때문에 11보다 작은 수의 배수들만 지워도 충분하다

        for (int i = 0; i < n; i++) {
            if (i * i <= n) temp = i + 1;
        }

        for (int i = 2; i < temp; i++) {
            for (int j = 2; i * j <= n; j++) {
                nums[i * j] = true;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (i > 1 && nums[i] == false) answer++;
        }
        return answer;
    }
}

