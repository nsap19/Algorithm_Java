package baekjoon_step23;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //행렬 A
        StringTokenizer st = new StringTokenizer(br.readLine());
        int An = Integer.parseInt(st.nextToken());
        int Am = Integer.parseInt(st.nextToken());
        int[][] A = new int[An][Am];

        for (int i = 0; i < An; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < Am; j++) {
                A[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        //행렬 B
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int Bn = Integer.parseInt(st3.nextToken());
        int Bm = Integer.parseInt(st3.nextToken());
        int[][] B = new int[Bn][Bm];

        for (int i = 0; i < Bn; i++) {
            StringTokenizer st4 = new StringTokenizer(br.readLine());
            for (int j = 0; j < Bm; j++) {
                B[i][j] = Integer.parseInt(st4.nextToken());
            }
        }

        for (int i = 0; i < An; i++) { //A의 행
            for (int j = 0; j < Bm; j++) { //B의 열
                int result = 0;
                for (int k = 0; k < Am; k++) { //A의 열, B의 행
                    result += A[i][k] * B[k][j];
                }
                bw.write(result + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
