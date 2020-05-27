package baekjoon_step23;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon6549 {
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String temp = br.readLine();
            if (temp.equals("0")) break;
            StringTokenizer st = new StringTokenizer(temp);
            int n = Integer.parseInt(st.nextToken());
            arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }


        }


    }

    private static long getMax(int start, int end) {
        if (start == end) return arr[start];
        int mid = (start+end) /2;
        long max = Math.max(getMax(start,mid),getMax(mid+1, end));

        long min = 1000000000;
        int len = end - start + 1;
        long width;
        int index;

        for (int i = start; i < end; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }

        width = min * len;
        return width;
    }
}
