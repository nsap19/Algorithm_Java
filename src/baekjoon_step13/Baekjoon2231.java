package baekjoon_step13;

import java.util.Scanner;

public class Baekjoon2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int temp;

        for (int i = 0; i < n; i++) { //생성자 i를 검사하는 반복문
            sum = i; //생성자를 먼저 더하고
            temp = i;
            while (temp > 0) { //각 자리수를 더하는 과정
                sum += temp % 10;
                temp /= 10;
            }

            if (sum == n) {
                System.out.println(i);
                break;
            }
        }
        if (sum != n) System.out.println(0); //생성자가 없는 경우에 0을 출력

    }
}
