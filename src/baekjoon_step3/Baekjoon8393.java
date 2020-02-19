package baekjoon_step3;

import java.util.Scanner;

public class Baekjoon8393 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int sum = 0;

        for (int i = 0; i <= a; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
