package baekjoon_step10;

import java.util.Scanner;

public class Baekjoon1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int pita = (int) Math.sqrt(Math.pow(w - x, 2) + Math.pow(h - y, 2));
        int len;

//        len = (h - y < w-h)? h-y : ((w-h < (int)Math.pow(w - x, 2) + Math.pow(h - y, 2)))? w-h : (int)Math.sqrt(Math.pow(w - x, 2) + Math.pow(h - y, 2));
        len = h - y;

        if (len > w - x) {
            if (w - x > pita)
                len = pita;
            else
                len = w - x;
        } else if (len > pita)
            len = pita;

        System.out.println(len);
    }
}
