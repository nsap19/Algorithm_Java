package baekjoon_step11;

import java.util.Scanner;

public class Baekjoon10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n >= 0 && n <= 12) System.out.println(factorial(n));
    }

    public static int factorial(int n) {
        if (n == 1 || n == 0) return 1;
        else return n * factorial(n - 1);
    }
}
