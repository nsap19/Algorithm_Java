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

        int x = 0;
        int y = 0;
        int temp = 0;
        for (int i = 1; i <= maxNum; i++) {
            System.out.println(x + " " + y);
            if (x < n && y < n && arr[x][y] == 0) {
                arr[x][y] = i;

            } else {
                temp++;
                if (temp == 3) temp -= 3;
            }
            x += dx[temp];
            y += dy[temp];
        }


        return answer;
    }
}
