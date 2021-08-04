package etc.programmers_Lv2;

import java.util.Arrays;

public class Programmers_Lv2_21 {
    static String[][] arr;
    public static void main(String[] args)  {
        System.out.println(Arrays.toString(solution(new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));


    }

    private static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int testCase = 0; testCase < 5; testCase++) {
            arr = new String[5][5];
            for (int i = 0; i < 5; i++) {
                arr[i] = places[testCase][i].split("");
            }
//            System.out.println(testCase);
            boolean status = true;
            loop: for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(arr[i][j].equals("P")){
                        status = check(i,j);
                        if(!status) break loop;

                    }
                }
            }
            if(status) answer[testCase] = 1;
            else answer[testCase]=0;
        }


        return answer;
    }

    private static boolean check(int r, int c){
        int nr = r, nc = c;
        //상하좌우로 붙어있는 경우
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,1,-1};
        for (int i = 0; i < 4; i++) {
            nr = r+dr[i];
            nc = c+dc[i];
//            System.out.println("case1 "+r+" "+c+" "+nr +" "+nc);

            if(nr<0 || nr >= 5 || nc < 0 || nc >=5) continue;
            if(arr[nr][nc].equals("P")) return false;
        }

        //상하좌우로 한칸 떨어져 있는 경우
        dr = new int[]{-2,2,0,0};
        dc = new int[]{0,0,-2,2};
        for (int i = 0; i < 4; i++) {
            nr = r+dr[i];
            nc = c+dc[i];

            if(nr<0 || nr >= 5 || nc < 0 || nc >=5) continue;
            if(arr[nr][nc].equals("P")) {
//                System.out.println("case2 "+r+" "+c+" "+nr +" "+nc);
                //칸막이가 없는 경우
                int tr = Math.abs(nr-r)/2;
                int tc = Math.abs(nc-c)/2;
                if(!arr[r+tr][c+tc].equals("X")) return false;
            }
        }

        //대각선에 위치해있는 경우
        dr = new int[]{-1,-1,1,1};
        dc = new int[]{-1,1,-1,1};

        for (int i = 0; i < 4; i++) {
            nr = r+dr[i];
            nc = c+dc[i];

            if(nr<0 || nr >= 5 || nc < 0 || nc >=5) continue;
            if(arr[nr][nc].equals("P")) {
//                System.out.println("case3 "+r+" "+c+" "+nr +" "+nc);

                //대각선 사이에 칸막이가 없는 경우
                if(!arr[r][nc].equals("X") || !arr[nr][c].equals("X")) return false;
            }
        }

        arr[r][c] = "O";

        return true;
    }
}
