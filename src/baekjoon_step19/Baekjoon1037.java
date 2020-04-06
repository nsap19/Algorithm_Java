package baekjoon_step19;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int result;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        result = arr[0] * arr[n - 1];

        bw.write(String.valueOf(result));
        bw.close();
    }
}
