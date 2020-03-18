package baekjoon_step5;

import java.io.*;

public class Baekjoon2523 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n * 2 - 1; i++) {
            if (i < n) {
                for (int j = 0; j <= i; j++) {
                    bw.write("*");
                }
            } else {
                for (int j = n - 1; j > i - n; j--) {
                    bw.write("*");
                }
            }

            bw.write("\n");
        }
        bw.close();
    }
}
