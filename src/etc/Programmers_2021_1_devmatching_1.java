package etc;

import java.io.*;
import java.util.Arrays;

public class Programmers_2021_1_devmatching_1 {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
        System.out.println(Arrays.toString(solution(6, 6, new int[][]{{2, 2, 5, 4}})));
        System.out.println(Arrays.toString(solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}})));
        System.out.println(Arrays.toString(solution(100, 100, new int[][]{{1,1,100,97}})));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows + 1][columns + 1]; //표는 1,1부터 채워짐

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                arr[i][j] = (i - 1) * columns + j; //아무 회전도 하지 않았을 때, i 행 j 열에 있는 숫자
            }
        }

        //초기 값 확인
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
//        System.out.println();

        for (int i = 0; i < queries.length; i++) {
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];

            int temp = arr[r1][c1]; //시작 위치 임시 저장
            int min = temp;

            for (int j = r1; j < r2; j++) { //직사각형 왼쪽 세로 범위 회전
                arr[j][c1] = arr[j + 1][c1];
                if (arr[j][c1] < min) min = arr[j][c1];
            }
            for (int j = c1; j < c2; j++) { //직사각형 하단 가로 범위 회전
                arr[r2][j] = arr[r2][j + 1];
                if (arr[r2][j] < min) min = arr[r2][j];
            }
            for (int j = r2; j > r1; j--) { //직사각형 오른쪽 세로 범위 회전
                arr[j][c2] = arr[j - 1][c2];
                if (arr[j][c2] < min) min = arr[j][c2];
            }
            for (int j = c2; j > c1 + 1; j--) { //직사각형 상단 가로 범위 회전
                arr[r1][j] = arr[r1][j - 1];
                if (arr[r1][j] < min) min = arr[r1][j];
            }

            arr[r1][c1 + 1] = temp; //시작 위치 임시저장 값 저장

            answer[i] = min;

            // 회전마다 배열 값 확인
//            for (int k = 0; k < arr.length; k++) {
//                System.out.println(Arrays.toString(arr[k]));
//            }
//            System.out.println();
        }

        return answer;
    }
}
