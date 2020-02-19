package baekjoon_step6;

import java.util.Scanner;

public class Baekjoon1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //과목갯수
        double[] score = new double[n]; //점수를 넣을 배열
        double max; //점수 중 최댓값
        double avg = 0;

        for (int i = 0; i < n; i++) { //점수 입력받아서 score배열에 넣기
            score[i] = sc.nextInt();
        }

        for (int i = 0; i < score.length; i++) {  //점수 오름차순으로 정렬
            for (int j = 0; j < n; j++) {
                if (score[i] < score[j]) {
                    double temp = score[j];
                    score[j] = score[i];
                    score[i] = temp;
                }
            }
        }

        max = score[n - 1]; // 점수 최댓값 초기화

        for (int i = 0; i < score.length; i++) { //각 점수 조작
            score[i] = score[i] / max * 100;
        }

        for (int i = 0; i < score.length; i++) { //총 점수 합하기
            avg += score[i];
        }

        avg /= score.length; //총점 평균 구하기

        System.out.println(avg);


    }
}
