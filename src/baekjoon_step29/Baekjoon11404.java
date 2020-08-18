package baekjoon_step29;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11404 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 100 * 100_000;
    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        init();

        floydWarshall();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                bw.write((arr[i][j] == INF ? 0 : arr[i][j]) + " ");
            }
            bw.write("\n");
        }
        bw.close();


    }

    private static void init() throws IOException {
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], INF);
        }

        for (int i = 0; i <= n; i++) {
            arr[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[start][end] = Math.min(cost, arr[start][end]);
        }
    }

    private static void floydWarshall() {
        for (int i = 1; i <= n; i++) { //경유 노드
            for (int j = 1; j <= n; j++) { //시작 노드
                if (i != j) { //경유노드 != 시작노드
                    for (int k = 1; k <= n; k++) { //도착 노드
                        if (j != k && i != k) { //시작노드 != 도착노드 && 경유노드 != 도착노드
                            if (arr[j][k] > arr[j][i] + arr[i][k]) //기존 값보다 경유한 값이 더 작을 때 갱신
                                arr[j][k] = arr[j][i] + arr[i][k];

                        }

                    }
                }

            }

        }
    }
}
