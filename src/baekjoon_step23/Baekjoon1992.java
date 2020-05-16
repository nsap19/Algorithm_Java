package baekjoon_step23;

import java.io.*;

public class Baekjoon1992 {
    public static int[][] arr;
    public static String result = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        divide(0, 0, n);
        bw.write(result);
        bw.close();
    }

    private static boolean check(int x, int y, int size, int num) {
        boolean same = true;
        loop:
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[y + i][x + j] != num) {
                    same = false;
                    break loop;
                }
            }
        }
        return same;
    }

    private static void divide(int x, int y, int size) {
        int num = arr[y][x];

        if (check(x, y, size, num)) {
            result += num;
        } else {
            result += "(";
            int newSize = size / 2;
            divide(x, y, newSize);
            divide(x + newSize, y, newSize);
            divide(x, y + newSize, newSize);
            divide(x + newSize, y + newSize, newSize);
            result += ")";
        }

    }

}
