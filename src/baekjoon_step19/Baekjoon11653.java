package baekjoon_step19;

import java.io.*;

public class Baekjoon11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int sosu = 2;

        while (n != 1) {
            if (n % sosu == 0) {
                n /= sosu;
                bw.write(String.valueOf(sosu) + "\n");
            } else sosu++;
        }

        bw.close();

    }
}
