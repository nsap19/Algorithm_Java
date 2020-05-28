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

    private static long getMax(int left, int right) {
        if (left == right) return arr[left];
        int mid = (left+right) /2;
        long ret = Math.max(getMax(left,mid),getMax(mid+1, right));

        int start = mid;
        int end = mid+1;
        long height = (long)Math.min(arr[start], arr[end]);
        ret = Math.max(ret, height*2);



        return ret;
    }
}
