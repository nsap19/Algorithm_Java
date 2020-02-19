package baekjoon_step11;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon2447_2 {
    public static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new char[n][n];

        for (int i = 0; i < n; i++) { //공백으로 초기화를 해놔야 null이 없이 진행 가능
            Arrays.fill(arr[i], ' ');
        }

        star(0, 0, n);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void star(int x, int y, int n) { //x와 y는 좌표적으로 시작점
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }
        int m = n / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue; //가로 세로가 1일때(가운데) 아래 함수는 실행하지 않고 다음 반복으로 넘어감
                star(x + (m * i), y + (m * j), m); //전체칸에서 3으로 계속 쪼개면서 한칸의 크기가 1일때 *을 삽입

            }

        }
    }
}
