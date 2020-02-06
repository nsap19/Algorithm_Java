package baekjoon_step9;

import java.util.Scanner;

public class Baekjoon2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] result = new int[t];

        for (int i = 0; i < t; i++) {
            int k = sc.nextInt(); //k층
            int n = sc.nextInt(); //n호
            int[] num = new int[n]; //각 호실의 사람수

            for (int j = 0; j < n; j++) {
                num[j] = j + 1; //0층의 각 호실의 사람수 저장 / 초기값 [1,2,3,4,...]
            }


            for (int j = 0; j < k; j++) { //층수 만큼 반복
                for (int l = 1; l < n; l++) {
                    num[l] += num[l - 1]; //l의 위치에 있던 값과 l-1의 위치에 있던 값 끼리 더함 [1, 1+2, 2+3, 3+4, ...] => 층수만큼 반복하면 값 나옴
                }
            }

            result[i] = num[n - 1]; //l의 최종 합으로 간 위치가 최종 결과값

        }
        for (int value : result) System.out.println(value);
    }
}
