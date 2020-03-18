package baekjoon_step5;

import java.io.*;

public class Baekjoon10996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n * 2; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    if (j % 2 == 0) bw.write("*");
                    else bw.write(" ");
                }
            } else {
                for (int j = 0; j < n; j++) {
                    if (j % 2 == 0) bw.write(" ");
                    else bw.write("*");
                }
            }
            bw.newLine();
        }
        bw.close();
    }
}
