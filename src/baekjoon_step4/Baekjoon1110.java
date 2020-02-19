package baekjoon_step4;

import java.util.Scanner;

public class Baekjoon1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cycle = 0;
        int input = sc.nextInt();
        int newint =0; //이게 문제
        int first = input;

        while (newint != first) { //newint를 0으로 초기화 했기 때문에 입력받은 값이 0이면 아예 while문이 돌지 않아 cycle이 1이 아닌 0으로 나옴
            newint = input;
            int one = newint % 10;
            int ten = newint / 10;
            int sum = ten + one;
            newint = (one * 10) + (sum % 10);
            cycle++;

            input = newint;

        }
        System.out.println(cycle);

    }
}
