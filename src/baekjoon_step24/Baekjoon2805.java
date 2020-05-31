package baekjoon_step24;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        Arrays.sort(arr);

        int start = 0;
        int end = max;
        long result = 0; //int->long으로 바꾸니 성공

        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(arr, m, mid)) {
                result = Math.max(result, mid);
                start = mid + 1;
            } else end = mid - 1;
        }

        bw.write(String.valueOf(result));
        bw.close();


    }

    private static boolean check(int[] arr, int m, int x) { //m은 남겨지는 길이, x는 절단기 설정 높이
        long result = 0; //int->long으로 바꾸니 성공

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - x > 0) result += arr[i] - x;
        }
//        System.out.println(x+" "+result+(result==m));

        return result >= m;
    }
}
