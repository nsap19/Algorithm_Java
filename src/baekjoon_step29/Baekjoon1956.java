package baekjoon_step29;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1956 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 400 * 10_000;
    static int v, e, result = INF;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        arr = new int[v + 1][v + 1];

        for (int i = 0; i <= v; i++)
            Arrays.fill(arr[i], INF);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            arr[start][end] = Math.min(dist, arr[start][end]);
        }

        //플로이드 와샬
        for (int i = 1; i <= v; i++) { //경유 노드
            for (int j = 1; j <= v; j++) { //시작 노드
                for (int k = 1; k <= v; k++) { //도착 노드
                    if (arr[j][k] > arr[j][i] + arr[i][k])
                        arr[j][k] = arr[j][i] + arr[i][k];
                }
            }
        }

        //사이클 중 최솟값 탐색
        for (int i = 1; i <= v; i++) {
            result = Math.min(arr[i][i], INF);
        }

        bw.write(result == INF ? "-1\n" : result + "\n");
        bw.close();
    }
}

