package etc;

import java.io.*;
import java.util.Arrays;

public class Programmers_2021_1_devmatching_1 {
    public static void main(String[] args) throws IOException {
//        System.out.println(Arrays.toString(solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
//        System.out.println(Arrays.toString(solution(6, 6, new int[][]{{2, 2, 5, 4}})));
        System.out.println(Arrays.toString(solution(3,3, new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}})));
//        System.out.println(Arrays.toString(solution(100, 100, new int[][]{{1,1,100,97}})));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows + 1][columns + 1]; //표는 1,1부터 채워짐

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                arr[i][j] = (i - 1) * columns + j; //아무 회전도 하지 않았을 때, i 행 j 열에 있는 숫자
            }
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            int x = x1, y = y1+1;
            int pre = arr[x1][y1];
            int next;
            int min = 100*100;

            while(!(x== x1 && y==y1)) {
//                System.out.println(x+" "+y);
                if(pre < min) min = pre;

                next = arr[x][y];
                arr[x][y] = pre;
                pre = next;

                if(x==x1 && y < y2){
                   y++;
                }
                else if(y==y2 && x < x2){
                    x++;
                }
                else if(x==x2 && y>y1){
                   y--;
                }
                else if(y==y1 && x>x1){
                    x--;
                }
            }
            arr[x][y] = pre;

            answer[i] = min;

            for (int k = 0; k < arr.length; k++) {
                System.out.println(Arrays.toString(arr[k]));
            }
            System.out.println();
        }


//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
        return answer;
    }
}
