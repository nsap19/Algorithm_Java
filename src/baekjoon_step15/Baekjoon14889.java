package baekjoon_step15;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon14889 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] S;
    static int min = 250000;
    static boolean[] people;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        S = new int[n][n];
        people = new boolean[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        teamMatch(0, n / 2);
        bw.write(String.valueOf(min));
        bw.close();
    }

    private static void teamMatch(int start, int r) { //조합의 방식으로 팀을 매칭해야함. r은 뽑아야 하는 팀원의 수(총 6명이면 3명을 뽑아야함)
        if (r == 0) {
            getScore(people);
            return;
        }

        //start에서 모든 경우의 수를 다 뽑은 후 i++이 됌
        for (int i = start; i < n; i++) {
            if (people[i] != true) {
                people[i] = true;
                teamMatch(i + 1, r - 1); //start보다 큰 수에서 사람을 뽑기 위해 i+1에서 범위 시작, 한명을 뽑았으니 뽑아야 할 사람의 수는 r-1
                people[i] = false;
            }
        }
    }

    private static void getScore(boolean[] people) {
        int score1 = 0;
        int score2 = 0;

        //팀의 조합 확인
//        for (int i = 0; i < people.length; i++) {
//            System.out.print(people[i] + " ");
//        }
//        System.out.println();

        for (int i = 0; i < people.length; i++) {
            for (int j = i; j < people.length; j++) {
                if (people[i] == true && people[j] == true) {
                    score1 += S[i][j];
                    score1 += S[j][i];
                }
                if (people[i] != true && people[j] != true) {
                    score2 += S[i][j];
                    score2 += S[j][i];
                }
            }
        }
        checkMin(Math.abs(score1 - score2));
    }

    private static void checkMin(int n) {
        if (min >= n) min = n;
    }
}
