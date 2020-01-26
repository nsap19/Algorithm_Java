package baekjoon_step3;

import java.util.Scanner;

public class Baekjoon10950 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();

        for (int i = 0; i < a; i++) {
            int b = input.nextInt();
            int c = input.nextInt();
            System.out.println(b + c);
        }
    }
}
