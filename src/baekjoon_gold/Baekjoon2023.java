package baekjoon_gold;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon2023 {
    static int n, arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];


        perm(0, 0);
        System.out.println(sb);
    }

    private static void perm(int cnt, int num) {
        if (cnt == n) {
//            System.out.println(num/10);
            sb.append(num / 10).append("\n");
            return;
        }

        int i = cnt == 0 ? 2 : 1;
        for (; i <= 9; i++) {
            int tempNum = num + i;
            if (isDecimal(tempNum)) perm(cnt + 1, tempNum * 10);
        }
    }

    private static boolean isDecimal(int num) {
        int sr = (int) Math.sqrt(num);
        for (int i = 2; i <= sr; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}