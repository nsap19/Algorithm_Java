package baekjoon_step7;

import java.util.Scanner;
import java.util.stream.Stream;

public class Baekjoon1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= n; i++) { //입력받은 수 까지 반복문 돌아 한수일때 갯수 ++
            if (hansoo(i)) {
                count++;
            }
        }

        System.out.println(count);

    }

    static boolean hansoo(int n) { //수의 자릿수가 등차수열을 이루는 수 인지 확인하는 메소드
        boolean result = false;
        int d; //공차
        int next_d;
        int[] digits = Stream.of(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();

        if (n < 100) {
            result = true; //1~9는 한 자리수, 10~99는 각 자릿수의 차가 공차인 등차수열
        } else if (n >= 100 && n < 1000) { //100~999
                d = digits[0] - digits[1];
                next_d = digits[1] - digits[2];

                if (d == next_d) {
                    result = true;
                }
            }
        return result;
    }
}
