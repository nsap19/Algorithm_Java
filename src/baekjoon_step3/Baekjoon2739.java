package baekjoon_step3;

import java.util.Scanner;

public class Baekjoon2739 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();

        if (a >= 1 && a <= 9) {
            for (int i = 1; i < 10; i++) {
                System.out.println(a+" * "+i+" = "+(a*i));
            }
        }
    }
}
