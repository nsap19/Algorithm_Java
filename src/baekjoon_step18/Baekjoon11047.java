package baekjoon_step18;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > k) continue;

            if (k - arr[i] >= 0) {
                count += k / arr[i];
                k %= arr[i];
//                System.out.println(k);
            }
        }

        bw.write(String.valueOf(count));
        bw.close();
    }
}
