package baekjoon_step28;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7576 {
    static int[][] tomato;
    static int m, n;
    static Queue<int[]> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); //가로 칸 수
        n = Integer.parseInt(st.nextToken()); //세로 칸 수

        tomato = new int[n][m];
        q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(str[j]);
                if (tomato[i][j] == 1) q.add(new int[]{i, j, 0}); //day를 큐에 함께 넘겨주는 것이 관건!
            }
        }

        bfs(0, 0);

        if (checkTomato()) bw.write(String.valueOf(day));
        else bw.write(String.valueOf(-1));
        bw.close();


    }

    public static void bfs(int i, int j) {
        day = 0;

        while (!q.isEmpty()) {
            int[] location = q.poll();
            day = location[2];

            for (int k = 0; k < 4; k++) {
                int r = location[0] + dx[k];
                int c = location[1] + dy[k];

                if (r >= 0 && r < n && c >= 0 && c < m) {
                    if (tomato[r][c] == 0) {
                        q.offer(new int[]{r, c, day + 1}); //day를 +1하여 큐에 함께 넘겨주는 것이 관건!
                        tomato[r][c] = 1;

                        //중간 과정 확인 출력문
//                        System.out.println(day);
//                        for (int[] arr : tomato) {
//                            for (int arr2 : arr) {
//                                System.out.print(arr2 + " ");
//                            }
//                            System.out.println();
//                        }
//                        System.out.println();
                    }
                }
            }
        }
    }

    public static boolean checkTomato() {
        for (int[] arr : tomato) {
            for (int arr2 : arr) {
                if (arr2 == 0) return false;
            }
        }
        return true;
    }
}

