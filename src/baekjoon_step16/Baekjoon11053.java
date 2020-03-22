package baekjoon_step16;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] total = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        total[0] = 1;
        if (n > 1) {
            for (int i = 1; i < arr.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[i] > arr[j] && total[j] == 0) total[j]++;
                    if (arr[i] > arr[j] && total[j] + 1 > total[i]) total[i] = total[j] + 1; //arr[i]보다 작은 arr[j]에 대해 total[j]가 가장 큰 수를 찾음
                }
            }
        }

//        for (int i = 0; i < total.length; i++) {
//            System.out.print(total[i] + " ");
//        }
//        System.out.println();

        Arrays.sort(total);
        bw.write(String.valueOf(total[n - 1]));
        bw.close();


    }
}
