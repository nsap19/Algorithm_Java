package etc.programmers_Lv2;

import java.io.*;
import java.util.Arrays;

public class Programmers_Lv2_8 {
    static int[] dx = {1, 0, -1};
    static int[] dy = {0, 1, -1};

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution(4)));

    }

    public static int[] solution(int n) {
        int[] answer = {};
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], 0);
        }

        int maxNum = 0;
        for (int i = n; i > 0; i--) maxNum += i;

        int x = 0, y = 0;
        arr[0][0] = 1;
        int nx, ny;
        int temp = 0;
        for (int i = 2; i <= maxNum; i++) {
            nx = x + dx[temp];
            ny = y + dy[temp];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 0) {
                temp = (temp + 1) % 3;
                nx = x + dx[temp];
                ny = y + dy[temp];
            }

            x = nx;
            y = ny;
            arr[nx][ny] = i;
        }

        answer = new int[maxNum];
        temp=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]!=0) answer[temp++] = arr[i][j];
            }
        }


        return answer;
    }
}
