package baekjoon_step19;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int temp1 = 0;
        int temp2 = a * b;

        while (b != 0) {
            temp1 = b;
            b = a % b;
            a = temp1;
        }
        bw.write(String.valueOf(temp1) + "\n");

        bw.write(String.valueOf(temp2 / temp1));

        bw.close();
    }
}
