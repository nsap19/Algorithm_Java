package etc;

import java.io.*;
import java.util.Arrays;

public class Etc1 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}));
    }

    public static int[] solution(int row, int col, int[][] square) {
        int[] answer = {};
        int[][] arr = new int[row+1][col+1]; //표는 1,1부터 채워짐

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                arr[i][j] = (i-1)*col + j;
            }
        }

        for (int i = 0; i < square.length ; i++) {
            int x1 = square[i][0];
            int y1 = square[i][1];
            int x2 = square[i][2];
            int y2 = square[i][3];

            int current= arr[x1][y1];
            int pre = arr[x1+1][y1];

            int n = x2-x1;
            int m = y2-y1;
            int x = x1, y = y1;

            for (int j = 0; j < n ; j++) {
                for (int k = j; k < m; k++) {

                }
            }
        }

//        for (int i = 0; i < arr.length ; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
        return answer;
    }
}
