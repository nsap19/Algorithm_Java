package baekjoon_silver;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon18428 {
    static boolean flag = true, result;
    static ArrayList<int[]> blank, teachers;
    static int[][] select = new int[3][2];
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
    static int N;
    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        blank = new ArrayList<>();
        teachers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken();
                if (map[i][j].equals("X"))
                    blank.add(new int[] { i, j });
                else if (map[i][j].equals("T"))
                    teachers.add(new int[] { i, j });
            }
        }

        makeObs(0,0);
        if(!result) System.out.println("NO");
    }

    private static void makeObs(int cnt, int start) {
        if (cnt == 3) {
            result = check();
            if(result) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for (int i = start; i < blank.size(); i++) {
            select[cnt][0] = blank.get(i)[0];
            select[cnt][1] = blank.get(i)[1];
            makeObs(cnt + 1, i + 1);
        }
    }

    private static boolean check() {
        String[][] temp = new String[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, temp[i], 0, N);
        }

        // 조합으로 뽑은 위치에 장애물 세우기
        for (int i = 0; i < 3; i++) {
            int r = select[i][0];
            int c = select[i][1];
            temp[r][c] = "O";
        }

        for (int i = 0; i < teachers.size(); i++) {
            int r = teachers.get(i)[0];
            int c = teachers.get(i)[1];

            for (int dir = 0; dir < 4; dir++) {
                int nr = r;
                int nc = c;

                while (true) {
                    nr += dr[dir];
                    nc += dc[dir];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N)
                        break;
                    if (temp[nr][nc].equals("O"))
                        break;
                    else if (temp[nr][nc].equals("S")) {
                        flag = false;
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
