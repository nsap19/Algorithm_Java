package baekjoon_step5;

import java.io.*;

public class Baekjoon2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int temp;

        for (int i = 0; i < n * 2 - 1; i++) {
            if (i < n) {
                for (int j = 0; j < i; j++) {
                    bw.write(" ");
                }
                for (int j = 1; j < (n - i) * 2; j++) {
                    bw.write("*");
                }
            } else {
                for (int j = 2; j < n * 2 - i; j++) {
                    bw.write(" ");
                }
                for (int j = (i - n + 1) * 2; j >= 0; j--) {
                    bw.write("*");
                }

            }

            bw.write("\n");
        }
        bw.close();
    }
}
