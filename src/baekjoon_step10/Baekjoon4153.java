package baekjoon_step10;

import java.util.Scanner;

public class Baekjoon4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result = "";

        while (true) {
            double a = Math.pow(sc.nextInt(), 2);
            double b = Math.pow(sc.nextInt(), 2);
            double c = Math.pow(sc.nextInt(), 2);
            if (a == 0 && b == 0 && c == 0) break;

            if (a + b == c) result += "right\n";
            else if (b + c == a) result += "right\n";
            else if (a + c == b) result += "right\n";
            else result += "wrong\n";
        }
        System.out.println(result);
    }
}
