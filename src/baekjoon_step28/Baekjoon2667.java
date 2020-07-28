package baekjoon_step28;

import java.io.*;
import java.util.PriorityQueue;

public class Baekjoon2667 {
    static int n;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        //입력
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int total = 0; //총 단지 수
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //각 단지내 집의 수를 오름차순으로 정렬하기 위해 PriorityQueue 사용
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    count = 0; //count는 각 단지 내 집의 수
                    total++;

                    dfs(i, j);

                    pq.add(count);
                }
            }

        }

        bw.write(total + "\n");

        while (!pq.isEmpty()) {
            bw.write(pq.poll() + "\n");
        }
        bw.close();
    }

    public static void dfs(int x, int y) {
        arr[x][y] = 0; //visited 배열 대신 조회한 집을 0으로 바꿈
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (arr[nx][ny] == 1) dfs(nx, ny);
            }
        }
    }
}
