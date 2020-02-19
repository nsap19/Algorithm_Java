package baekjoon_step9;

import java.util.Scanner;

public class Baekjoon1011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] result = new int[t];

        for (int i = 0; i < t; i++) {
            long x = sc.nextInt();
            long y = sc.nextInt();
            long distance = y - x;
            int n = 0; //공간이동 횟수
            long move = 0; //한 횟수당 이동 거리
            long temp = 0; //총 이동거리

            while (temp < distance) {
                move++;
                n++;
                temp += move; //x쪽 먼저 move 만큼 이동

                if (distance - temp > move) { //남은 거리가 move보다 크면 y쪽에서 move만큼 이동
                    n++;
                    temp += move;
                }

//                System.out.print(temp + " " + move);
//                System.out.println();

            }

            result[i] = n;

        }
        for (int value : result) System.out.println(value);
    }
}
