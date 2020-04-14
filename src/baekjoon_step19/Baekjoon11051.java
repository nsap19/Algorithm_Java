package baekjoon_step19;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = (factorial(n) / (factorial(n - k) * factorial(k))) % 10007;
        bw.write(String.valueOf(result));
        bw.close();
    }

    public static int factorial(int n) {
        if (n == 1 || n == 0) return 1;
        else return n * factorial(n - 1) % 10007;
    }
}
