package baekjoon_step13;

import java.util.Scanner;

public class Baekjoon7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //전체 사람 수
        int[][] list = new int[n][3]; //몸무게, 키, 등수를 저장

        for (int i = 0; i < n; i++) {
            list[i][0] = sc.nextInt(); //몸무게
            list[i][1] = sc.nextInt(); //키
            list[i][2] = 1; //등수를 1로 초기화
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (list[i][0] < list[j][0] && list[i][1] < list[j][1]) list[i][2]++;
                //키와 무게가 작은 배열 등수 ++
            }
        }


        for (int i = 0; i < n; i++) {
            System.out.println(list[i][2]);

        }
    }
}
