package baekjoon_step10;

import java.util.Scanner;

public class Baekjoon9020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //테스트케이스
        String result = "";//골드바흐 파티션 결과 값

        /* n의 최대범위가 10000이기때문에 에라토스테네스의 체를 통해 미리 소수를 구해놓음 */
        boolean[] nums = sosoo(10000);

        for (int i = 0; i < t; i++) { //테스트케이스 수 만큼 반복
            int n = sc.nextInt(); //짝수 n (4<=n<=10000)
            int a = n / 2, b = n / 2;

            while (true) {
                if (nums[a] == false && nums[b] == false) {
                    result += a + " " + b + "\n";
                    break;
                } else {
                    a--;
                    b++;
                }
            }

        }
        System.out.println(result);
    }

    //에라토스테네스의 체를 통해 범위 안의 소수를 구하는 함수
    static boolean[] sosoo(int n) {
        boolean[] nums = new boolean[n + 1];
        int temp = 0;

        for (int i = 0; i < 10000; i++) {
            if (i * i <= 10000) temp = i + 1;
        }

        for (int i = 2; i < temp; i++) { //소수의 배수를 제외하는 과정
            for (int j = 2; i * j <= 10000; j++) {
                nums[i * j] = true;
            }
        }

        return nums;
    }

}
