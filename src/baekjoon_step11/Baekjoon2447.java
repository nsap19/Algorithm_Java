package baekjoon_step11;

import java.util.Scanner;

public class Baekjoon2447 {
    public static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
//        char[][] result = star(n);

//        if (n != 3) n /= 3;
        arr = new char[n][n];

        star(n);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            System.out.println();
        }
    }

    public static char[][] star(int n) {
//        arr = new char[n][n];

        if (n == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        arr[i][j] = ' ';
                    } else arr[i][j] = '*';
                }
            }
            return arr;
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i % 3 == 1 && j % 3 == 1) {
                        arr[i][j] = ' ';
                    } else arr[i][j] = star(n / 3)[i/3][j/3];
                }
            }
        }

        return arr;
    }
}
