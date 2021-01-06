package etc.programmers_Lv2;

import java.io.*;
import java.util.Arrays;

public class Programmers_Lv2_9 {
    static int M, N;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count; //한 영역의 크기

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));

    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0; //영역 갯수
        int maxSizeOfOneArea = 0; //가장 큰 영역의 크기
        M = m;
        N = n;
        arr = new int[m][n];

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length ; j++) {
                arr[i][j] = picture[i][j];
            }
        }

        int color;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    color = arr[i][j];
                    count = 0;
                    numberOfArea++;

                    dfs(i, j, color);

                    if (count > maxSizeOfOneArea) maxSizeOfOneArea = count;
                }
            }
        }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void dfs(int x, int y, int color) {
        count++;
        arr[x][y] = 0; //count한 부분 0으로 처리

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (arr[nx][ny] == color) dfs(nx, ny, color);
            }
        }
    }
}
