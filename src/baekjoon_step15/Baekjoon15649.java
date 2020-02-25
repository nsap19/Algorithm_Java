package baekjoon_step15;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon15649 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //수의 범위(1~n)
        int m = Integer.parseInt(st.nextToken()); //뽑는 수의 갯수
        int[] arr = new int[n];
        int[] result = new int[m];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        permutation(arr, result, visited, 0, n, m);

        bw.close();

    }

    private static void permutation(int[] arr, int[] result, boolean[] visited, int depth, int n, int m) throws IOException { //순열(순서있게 배열)
        if (depth == m) {
            print(result, m);
            return;
        }

        for (int i = 0; i < n; i++) { //visit 검사를 위한 for문
            if (visited[i] != true) {
                visited[i] = true;
                result[depth] = arr[i];
                permutation(arr, result, visited, depth + 1, n, m);
                visited[i] = false;
            }
        }


    }

    private static void print(int[] result, int m) throws IOException {
        for (int i = 0; i < m; i++) {
            bw.write(result[i] + " ");
        }
        bw.write("\n");
    }
}
