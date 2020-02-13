package baekjoon_step11;

import java.util.Scanner;

public class Baekjoon2447 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[][] result = star(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    public static String[][] star(int n) {
        String[][] arr;

        if (n == 3) {
            arr = new String[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        arr[i][j] = " ";
                    } else arr[i][j] = "*";
                }
            }
            return arr;
        } else {
            arr = new String[n/3][n/3] ;
            for (int i = 0; i < n/3; i++) {
                for (int j = 0; j < n/3; j++) {
                    if (i % 3 == 0 && j % 3 == 0) {
                        arr[i][j] = "";
                    } else arr = star(n / 3);
                }
            }
        }
        return arr;
    }
}
