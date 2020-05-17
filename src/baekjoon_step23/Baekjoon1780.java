package baekjoon_step23;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon1780 {
    public static int[][] arr;
    public static int minusOne = 0;
    public static int zero = 0;
    public static int one = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, n);
        bw.write(String.valueOf(minusOne) + "\n");
        bw.write(String.valueOf(zero) + "\n");
        bw.write(String.valueOf(one));

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
            switch (num) {
                case -1:
                    minusOne++;
                    break;
                case 0:
                    zero++;
                    break;
                case 1:
                    one++;
                    break;
            }
        } else {
            size /= 3;
            divide(x, y, size); //0,0
            divide(x + size, y, size); //3,0
            divide(x + size * 2, y, size); //6,0

            divide(x, y + size, size); //0,3
            divide(x + size, y + size, size); //3,3
            divide(x + size * 2, y + size, size); //6,3

            divide(x, y + size * 2, size); //0,6
            divide(x + size, y + size * 2, size); //3,6
            divide(x + size * 2, y + size * 2, size); //6,6

        }
    }
}
