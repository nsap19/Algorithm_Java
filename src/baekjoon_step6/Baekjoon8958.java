package baekjoon_step6;

import java.util.Scanner;

public class Baekjoon8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); //테스트 케이스 수 입력받기
        String[] score = new String[t];
        String[] one_score;
        int sum;
        int s;

        for (int i = 0; i < t; i++) { //각 정답 입력받기
            score[i] = sc.next();
        }


        for (int i = 0; i < t; i++) {   //한줄의 정답 내용을 배열에 각각 담음
            one_score = new String[score[i].length()]; //one_score는 한줄의 정답을 담은 배열
            one_score = score[i].split("");
            s = 0;
            sum = 0;

            for (int j = 0; j < score[i].length(); j++) {
                if (one_score[j].contains("O")) {//답이 O면 +1점
                    s++;
                } else if (one_score[j].contains("O") && j > 0 && one_score[j - 1].equals(one_score[j])) { //연속된 답이면 ++
                    s++;
                } else { //답이 x면 0점
                    s = 0;
                }
                sum += s; //각각의 점수를 더함
            }

            System.out.println(sum); //한줄의 정답(one_score)배열에 대한 점수 총합
        }
    }
}
