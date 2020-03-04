package baekjoon_step15;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon14888 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[] nums;
    public static int[] operators;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        nums = new int[n];
        operators = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operators.length; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }




    }
}
