package baekjoon_step8;

import java.util.Scanner;

public class Baekjoon2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] a = sc.next().split("");
        String[] b = sc.next().split("");
        int ia = 0;
        int ib = 0;
        int max;
        int temp = 1;

        for (int i = 0; i < 3; i++) {
            ia += Integer.parseInt(a[i]) * temp;
            ib += Integer.parseInt(b[i]) * temp;
            temp *= 10;
        }

        max = (ia > ib) ? ia : ib;
        System.out.println(max);
    }
}
