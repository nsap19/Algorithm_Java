package baekjoon_step4;

import java.util.Scanner;

public class Bekjoon1110_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cycle = 0;
        int input = sc.nextInt();
        int newint;
        int first = input;

        do{
            newint = input;
            int one = newint % 10;
            int ten = newint / 10;
            int sum = ten + one;
            newint = (one * 10) + (sum % 10);
            cycle++;

            input = newint;

        }
        while (newint != first);
        System.out.println(cycle);

    }
}
