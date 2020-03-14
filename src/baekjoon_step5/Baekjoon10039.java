package baekjoon_step5;

import java.io.*;

public class Baekjoon10039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;

        for (int i = 0; i < 5; i++) {
            int score = Integer.parseInt(br.readLine());

            if (score >= 40) result += score;
            else result += 40;
        }

        bw.write(String.valueOf(result / 5));
        bw.close();
    }
}
