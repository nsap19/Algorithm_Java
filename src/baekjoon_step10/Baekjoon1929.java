package baekjoon_step10;

import java.util.Scanner;

public class Baekjoon1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); //범위최솟값
        int n = sc.nextInt(); //범위최댓값
        boolean[] nums = new boolean[n + 1]; //초기값은 전체 false, 소수의 배수는 모두 true처리 할것임
        int temp = 0; //배수를 돌릴 기준 ex) 1~120이면 11*11 >120이기 때문에 11보다 작은 수의 배수들만 지워도 충분하다

        for (int i = 0; i < n; i++) {
            if (i * i <= n) temp = i + 1;
        }

        for (int i = 2; i < temp; i++) {
            for (int j = 2; i * j <= n; j++) {
                nums[i * j] = true;
            }
        }

        for (int i = m; i <= n; i++) {
            if (i > 1 && nums[i] == false) System.out.println(i);
        }

    }
}
