package baekjoon_step16;

import java.io.*;

public class Baekjoon9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        long[] arr = new long[101];

        for (int i = 1; i <= 3; i++) {
            arr[i] = 1;
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int j = 4; j <= n; j++) {
                arr[j] = arr[j - 3] + arr[j - 2];
            }

//            for (int j = 0; j <= n; j++) {
//                System.out.print(arr[j]+" ");
//            }

            bw.write(String.valueOf(arr[n] + "\n"));
        }

        bw.close();
    }
}
