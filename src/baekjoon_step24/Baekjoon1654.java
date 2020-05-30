package baekjoon_step24;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[k];
        long max = 0;

        for (int i = 0; i < k; i++) {
            arr[i] = Long.parseLong(br.readLine());
            if (max < arr[i]) max = arr[i];
        }

        long start = 1;
        long end = max;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (check(arr, n, mid)) {
                result = Math.max(result, mid);
                start = mid + 1;
            } else end = mid - 1;
        }

        bw.write(String.valueOf(result));
        bw.close();

    }

    private static boolean check(long[] arr, int n, long x) {//arr은 랜선길이가 담긴 배열, n은 만들어야할 랜선의 갯수, x는 잘라야하는 길이
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i] / x;
        }
        return count >= n; //길이를 x로 잘랐을 때  n개 이상인지 리턴
    }
}
