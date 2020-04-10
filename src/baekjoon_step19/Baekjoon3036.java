package baekjoon_step19;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int r1 = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int gcd_result = gcd(r1, arr[i]);
            int bunja = r1 / gcd_result;
            int bunmo = arr[i] / gcd_result;
            bw.write(bunja + "/" + bunmo + "\n");
        }

        bw.close();
    }

    static int gcd(int a, int b) {
        if (a % b == 0) return b;

        return gcd(b, a % b);
    }
}
