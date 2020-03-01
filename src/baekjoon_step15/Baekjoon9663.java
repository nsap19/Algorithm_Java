package baekjoon_step15;

import java.io.*;

class Baekjoon9663 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cols = new int[n]; // i행에 들어갈 퀸의 좌표 (하나의 줄(행)에는 하나의 퀸만 존재하기 때문에 i번째줄에 있는 퀸의 좌표를 표현할 1차원 배열만 있으면 됌)

        int result = backtracking(0, cols, n); //0번째 행부터 확인

        bw.write(String.valueOf(result)); //n이 주어졌을 때, 퀸을 놓는 방법의 수 출력
        bw.close();
    }


    public static int backtracking(int level, int[] cols, int n) throws IOException { //level은 현재의 위치(행)
//        if (level == n) print(cols);
        if (level == n) count++;

        else {
            for (int i = 0; i < n; i++) { //level행의 i열
                cols[level] = i; //퀸을 i에 놓고
                if (isPossible(level, cols)) //i의 자리에 퀸을 놓는게 가능한지 확인
                    backtracking(level + 1, cols, n); //가능하면 i에 퀸을 놓고 다음 열 진행
            }
        }

        return count; //총 방법의 수 리턴
    }

    public static boolean isPossible(int level, int[] cols) {
        for (int i = 0; i < level; i++) {
            //level 위치에 현재 시험할 퀸이 놓여져 있는 상태이고
            //우리는 그 퀸과 i= 0 ~ level-1 에 놓여있는 퀸이 문제를 일으키는지만 보면 된다.

            if (cols[i] == cols[level] || Math.abs(level - i) == Math.abs(cols[level] - cols[i])) {
                //cols[i]: 현재 비교하는 행 이전의 퀸 위치, cols[level]: 현재 비교하는 행

                // 이전 퀸들의 위치가 현재 비교하는 퀸의 위치와 같은 열에 있는 경우 -> false
                // "level -i: 밑변, cols[level]-cols[i]: 높이"로 본다면 두 값이 같을 때 퀸은 대각선상에 있다는 의미 -> false
                return false;
            }
        }
        return true; // 위 경우를 제외한 경우에는 true
    }

//    private static void print(int[] cols) throws IOException {
//        for (int i = 0; i < cols.length; i++) {
//            bw.write(cols[i] + " ");
//        }
//        bw.write("count="+ ++count);
//
//        bw.newLine();
//    }

}
