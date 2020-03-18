package baekjoon_step2;

import java.io.*;

public class Baekjoon14681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int result;

        if (x > 0) {
            if (y > 0) result = 1;
            else result = 4;
        } else if (y > 0) result = 2;
        else result = 3;

        bw.write(String.valueOf(result));
        bw.close();
    }
}
