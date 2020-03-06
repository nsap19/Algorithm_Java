package baekjoon_step16;

import java.io.*;

public class Baekjoon1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long[] fibo = new long[n + 1];
            int[] zero_count = new int[n + 2];
            int[] one_count = new int[n + 2];

            zero_count[0] = 1;
            zero_count[1] = 0;
            one_count[0] = 0;
            one_count[1] = 1;

            for (int j = 2; j <= n; j++) {
                zero_count[j] = zero_count[j - 2] + zero_count[j - 1];
                one_count[j] = one_count[j - 2] + one_count[j - 1];

            }

//            for (int j = 0; j <= n; j++) {
//                System.out.print(zero_count[j]+" ");
//            }
//            System.out.println();
//            for (int j = 0; j <= n; j++) {
//                System.out.print(one_count[j]+" ");
//            }
            bw.write(String.valueOf(zero_count[n] + " " + one_count[n] + "\n"));

        }
        bw.close();

    }


}
