package baekjoon_step24;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //집의 갯수
        int c = Integer.parseInt(st.nextToken()); //공유기 갯수

        int[] arr = new int[n]; //집의 좌표
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 1;
        int end = arr[n - 1] - arr[0];
        long result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(arr, c, mid)) {
                result = Math.max(result, mid);
                start = mid + 1;
            } else end = mid - 1;
        }

        bw.write(String.valueOf(result));
        bw.close();
    }

    private static boolean check(int[] arr, int c, int x) { //c는 배치해야하는 공유기 갯수, x는 배치하려는 공유기의 거리
        int count = 1;
        int point = arr[0] + x;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= point) {
                count++;
                point = arr[i] + x;
            }
        }

        return count >= c;
    }
}
