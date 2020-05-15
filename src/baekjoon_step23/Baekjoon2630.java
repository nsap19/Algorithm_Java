package baekjoon_step23;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon2630 {
    private static int[][] arr;
    public static int blue;
    public static int white;

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

//        bw.write(String.valueOf(blue)+"\n"+String.valueOf(white));
        bw.write(white + "\n" + blue);

        bw.close();
    }

    private static void divide(int x, int y, int n) { //시작 지점 x,y / 한 변의 길이 n

        if (n == 1) {
            if (arr[y][x] == 1) blue++;
            else white++;
            return;
        }

        boolean same = true;
        int color = arr[y][x];

        loop1:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[y + i][x + j] != color) {
                    same = false;
                    break loop1;
                }
            }
        }

        if (same) {
            if (arr[y][x] == 1) blue++;
            else white++;
            return;
        }

        int newN = n / 2;
        divide(x, y, newN);
        divide(x + newN, y, newN);
        divide(x, y + newN, newN);
        divide(x + newN, y + newN, newN);
    }
}

