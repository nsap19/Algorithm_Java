package baekjoon_step16;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (!st.hasMoreTokens()) arr[i][j] = 10000;
                else arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] < 10000) {
                    if (j == 0) arr[i][j] += arr[i - 1][j]; //맨앞
                    else if (j == i) arr[i][j] += arr[i - 1][j - 1]; //맨 뒤(i열에는 i개만큼 숫자가 놓여 있음)
                    else arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

        Arrays.sort(arr[n - 1]);
        bw.write(String.valueOf(arr[n - 1][n - 1]));
        bw.close();
    }
}
