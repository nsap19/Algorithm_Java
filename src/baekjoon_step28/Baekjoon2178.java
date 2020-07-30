package baekjoon_step28;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2178 {
    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // N * M
        n = Integer.parseInt(st.nextToken()); //행
        m = Integer.parseInt(st.nextToken()); //렬

        map = new int[n][m];
        visited = new boolean[n][m];

        //입력
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }


        bfs(0, 0);

        bw.write(String.valueOf(map[n-1][m-1]));
        bw.close();

    }

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{i, j});
        visited[i][j] = true; //시작점인 0,0 고정

        while (!queue.isEmpty()) {
            int[] location = queue.poll();
//            visited[i][j] = true; //시작점인 0,0 고정
            System.out.println("location : " + location[0] + " " + location[1]);

            for (int k = 0; k < 4; k++) {
                int r = location[0] + dx[k];
                int c = location[1] + dy[k];

                if (r >= 0 && r < n && c >= 0 && c < m) {
                    if (map[r][c] != 0 && !visited[r][c]) {
                        queue.offer(new int[]{r, c});
                        visited[r][c] = true;
                        map[r][c] = map[location[0]][location[1]] + 1;
                    }
                }
            }

            //중간 과정 확인 출력문
            for (int[] arr : map) {
                for (int arr2 : arr) {
                    System.out.print(arr2 + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
