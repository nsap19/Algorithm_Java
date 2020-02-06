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
            int n = 2; //공간이동 횟수 /처음과 끝 횟수는 1씩으로 정해져있으니 기본 2
            long move = 1; //한 횟수당 이동 거리
            long temp = x + 1; //현 위치

            while (temp < y - 1) {
                if (temp + move + 1 <= y - 1) {
                    temp += move + 1;
                    move += 1;
                } else if (temp + move <= y - 1) temp += move;
                else if (temp + move - 1 <= y - 1) {
                    temp += move - 1;
                    move -= 1;
                }
                n++;
//                System.out.print("temp:"+temp+" move:"+move);
//                System.out.println();
            }
            result[i] = n;

        }
        for (int value : result) System.out.println(value);
    }
}
