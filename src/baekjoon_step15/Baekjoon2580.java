package baekjoon_step15;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon2580 {
    public static int[][] arr = new int[9][9];
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0);


    }

    public static void backtracking(int row, int col) throws IOException {
        if (col == 9) {
            col = 0;
            row++;
        }

        if (row == 9) {
            print();
            System.exit(0); //스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력하기 위해 시스템 종료
        }


        if (arr[row][col] == 0) { //0인 부분의 숫자를 탐색
            for (int i = 1; i < 10; i++) {
                if (isPossible(row, col, i)) { //0인 부분의 값을 임의로 i를 넣어놓고 그 값이 가능하다고 판단되면
                    arr[row][col] = i; //해당위치에 i를 넣고
                    backtracking(row, col + 1); //다음 빈칸에 들어갈 값이 가능한지 확인 - 계속해서 가능한 값들로 이루어지면 row가 9가 되어 출력
                    arr[row][col] = 0; // 이 부분으로 돌아왔다는 것은 i가 해당위치에 알맞지 않은 값으로 판단 -> 0으로 초기화 해준다
                }
            }
        } else backtracking(row, col + 1); //arr[row][col]이 0이 아니면 다음 칸 탐색

    }

    public static boolean isPossible(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value) return false; //해당 위치의 행을 전체 탐색, 인자로 넘어온 value가 이미 다른 열에 있다면 false 리턴
            if (arr[i][col] == value) return false; //해당 위치의 열을 전체 탐색, 인자로 넘어온 value가 이미 다른 열에 있다면 false 리턴
        }

        if (!checkSquare(row, col, value))
            return false; //3x3 정사각형안에 value가 있는지 확인. 없다면 checkSquare함수에서 true를 리턴. 여기선 false인 경우 false 리턴

        return true; //위 경우를 제외한 모든 경우는 true
    }

    public static boolean checkSquare(int row, int col, int value) {
        row = (row / 3) * 3;
        col = (col / 3) * 3;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (arr[i][j] == value) return false;
            }
        }

        return true;
    }

    public static void print() throws IOException {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }
        bw.close();
    }

}
