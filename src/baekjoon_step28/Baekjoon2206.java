package baekjoon_step28;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2206 {
    static int n, m, result;
    static int[][] map, visit; //visit은 공사횟수
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    static class Wall {
        int x;
        int y;
        int dis; //이동 거리
        int drill; //벽을 부순 횟수

        public Wall(int x, int y, int dis, int drill) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.drill = drill;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
                visit[i][j] = Integer.MAX_VALUE;
            }
        }

        result = Integer.MAX_VALUE;

        bfs(0, 0);

        if (result == Integer.MAX_VALUE) bw.write(String.valueOf(-1));
        else bw.write(String.valueOf(result));
        bw.close();

    }

    public static void bfs(int i, int j) {
        Queue<Wall> queue = new LinkedList<>();

        queue.offer(new Wall(i, j, 1, 0));
        visit[i][j] = 0;

        while (!queue.isEmpty()) {
            Wall wall = queue.poll();

            if (wall.x == n - 1 && wall.y == m - 1) {
                result = wall.dis;
                break;
            }

            for (int k = 0; k < 4; k++) {
                int nx = wall.x + dx[k];
                int ny = wall.y + dy[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; //범위 밖이면 queue에 추가하지 않음.

                //다음에 나온 공사횟수 값(visit[nx][ny])이 기존에 갖고 있던 값(wall.drill)보다 작거나 같으면 queue에 추가해주지 않아도 됌.
                if (visit[nx][ny] <= wall.drill) continue;

                if (map[nx][ny] == 0) { //벽이 아닐때 그냥 지나갈 수 있으므로 거리만 +1함
                    visit[nx][ny] = wall.drill;
                    queue.add(new Wall(nx, ny, wall.dis + 1, wall.drill));
                } else { //벽일 때
                    if (wall.drill == 0) { //wall의 공사횟수가 0일때만 진행 가능
                        visit[nx][ny] = wall.drill + 1;
                        queue.add(new Wall(nx, ny, wall.dis + 1, wall.drill + 1));
                    }
                }
            }
        }
    }
}
