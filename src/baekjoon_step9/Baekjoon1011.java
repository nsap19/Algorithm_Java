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
            long move = 1; //한 횟수당 이동 거리
            long temp = 0; //총 이동거리

            while (temp < distance) {
                n += 2;
                temp += move * 2; //x와 y쪽 양쪽에서 같은 거리만큼 이동(처음 값은 1)

//                System.out.print(temp+" "+move);
//                System.out.println();

                if (distance - temp >= move * 2) { //움직여야하는 남은 거리가 move보다 크다면
                    move++;
                } else if (distance - temp < move * 2 && distance - temp == move) {
                    temp += move;
                    n++;
                }
            }

            result[i] = n;

        }
        for (int value : result) System.out.println(value);
    }
}
