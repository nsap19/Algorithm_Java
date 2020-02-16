package baekjoon_step13;

import java.util.Scanner;

public class Baekjoon1018 {
    private static String[] chess;
    public static String[] white = {"WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW"};
    public static String[] black = {"BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //세로
        int m = sc.nextInt(); //가로
        chess = new String[n];
        int result = 0;
        int temp = 250000; //결과 값의 최댓값

        for (int i = 0; i < n; i++) {
            chess[i] = sc.next();
        }

        for (int i = 0; i + 7 < n; i++) {
            for (int j = 0; j + 7 < m; j++) {
                if (checkw(i, j) < checkb(i, j)) {
                    result = checkw(i, j);
//                    System.out.println("white" + result + " " + i + " " + j);
                } else {
                    result = checkb(i, j);
//                    System.out.println("black"+result+" "+ i+" "+j);

                }
                if (temp > result) temp = result;
            }
        }

        System.out.println(temp);
    }

    public static int checkw(int i, int j) {
        int result = 0;
        for (int k = i; k < i + 8; k++) { //i~i+7
            for (int l = j; l < j + 8; l++) {
                if (chess[k].charAt(l) != white[k - i].charAt(l - j)) result++;
            }
        }
        return result;
    }

    public static int checkb(int i, int j) {
        int result = 0;
        for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
                if (chess[k].charAt(l) != black[k - i].charAt(l - j)) result++;
            }
        }
        return result;
    }
}
