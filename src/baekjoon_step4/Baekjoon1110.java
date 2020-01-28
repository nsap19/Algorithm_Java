package baekjoon_step4;

import java.util.Scanner;

public class Baekjoon1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cycle = 0;
        int input = sc.nextInt();
        int newint = 0;
        int first = input;

        while (newint != first) {
            newint = input;

            int one = newint % 10;
            int ten = (newint - one) / 10;
            int sum = ten + one;
            newint = (one * 10) + (sum % 10);
            cycle++;
            input = newint;

        }
        System.out.println(cycle);

    }
}
