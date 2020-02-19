package baekjoon_step9;

import java.util.Scanner;

public class Baekjoon2292 {
    public static void main(String[] args) {
        // 1 : 2~7(6개) : 8~19(12개) : 20~37(16개)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = 1;

        for (int i = 0; ; i++) {
            temp += 6 * i;
            if (temp >= n) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
