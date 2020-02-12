package baekjoon_step11;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon2447 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] result = star(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

    public static char[][] star(int n) {
        int x = n;
        int y = n;
        char[][] arr = new char[x][y];

        if (Math.cbrt(n) == 1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != 1 && j != 1) {
                        arr[i][j] = '*';
                    }
                }
            }
            return arr;
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != 1 && j != 1) {
                        arr[i][j] = ' ';
                    }
                }
            }
            return star(n / 3);
        }


    }
}
