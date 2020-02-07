package baekjoon_step9;

import java.util.Scanner;

public class Baekjoon2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int bongji = 0;
        int a = 0; //5키로 봉지
        int b = 0; //3키로 봉지
        int result = 0;

        a = n / 5; //a의 최댓값

        if ((n % 5) % 3 == 0) { //5키로 최대로 하고 남은 값이 3의 배수면
            b = (n - 5 * a) / 3;
            result = a + b;
        } else {
            while (true) {
                if (a > 0) {
                    a--;
                    if ((n - 5 * a) % 3 == 0) {
                        b = (n - 5 * a) / 3;
                        result = a + b;
                        break;
                    }
                }
                if (a == 0 && n % 3 == 0) { //비효율적
                    b = n / 3;
                    result = b;
                    break;
                }
                if (a == 0 && n % 3 != 0) { //비효율적
                    result = -1;
                    break;
                }
            }
        }


        System.out.println("a=" + a + " b=" + b);
        System.out.println(result);

    }
}
