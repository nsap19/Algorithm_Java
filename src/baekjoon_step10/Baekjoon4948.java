package baekjoon_step10;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon4948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> results = new ArrayList<>(); //각 케이스마다 소수의 개수를 저장해놓는 arralist

        /* 범위가 n~2n이기때문에 미리 구해야 할 소수 범위는 123456*2 (n의 최대범위=123456) */
        boolean[] nums = new boolean[123456 * 2 + 1]; //초기값은 전체 false, 소수의 배수는 모두 true처리 할것임
        int temp = 0; //배수를 돌릴 기준 ex) 1~120이면 11*11 >120이기 때문에 11보다 작은 수의 배수들만 지워도 충분하다

        for (int i = 0; i < 123456 * 2; i++) {
            if (i * i <= 123456) temp = i + 1;
        }

        for (int i = 2; i < temp; i++) {
            for (int j = 2; i * j <= 123456 * 2; j++) {
                nums[i * j] = true;
            }
        }
        /* 소수 구하는 과정 끝*/

        /* 입력을 받고 n~2n까지 수중에 소수(num[i]가 false인것)의 갯수를 구해서 arraylist에 저장 */
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            int sosoo = 0;

            for (int i = n + 1; i <= 2 * n; i++) {
                if (i > 1 && nums[i] == false) sosoo++;
            }

            results.add(sosoo);
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}
