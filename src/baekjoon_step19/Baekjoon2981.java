package baekjoon_step19;

import java.io.*;
import java.util.Arrays;

public class Baekjoon2981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int val = arr[1] - arr[0]; //val은 최대공약수
        for (int i = 2; i < arr.length; i++) {
            val = gcd(val, arr[i] - arr[i - 1]);
        }

        for (int i = 2; i <= val; i++) {
            if (val % i == 0) bw.write(String.valueOf(i) + " ");
        }

        bw.close();
    }

    static int gcd(int a, int b) {
        if (a % b == 0) return b;

        return gcd(b, a % b);
    }
}
