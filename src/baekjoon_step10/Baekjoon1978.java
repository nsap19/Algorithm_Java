package baekjoon_step10;

import java.util.Scanner;

public class Baekjoon1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //주어질 숫자의 갯수
        int num;
        int sosoo = 0;

        for (int i = 0; i < n; i++) {
            num = sc.nextInt();
            int check = 0; //약수 쌍의 갯수

            for (int j = 1; j < num; j++) {
                if (num % j == 0) check++; // 소수는 자신보다 작은 두 개의 자연수를 곱하여 만들 수 없는 1보다 큰 자연수
            }
            if (num > 1 && check == 1) {
                sosoo++;
            }
        }
        System.out.println(sosoo);
    }
}
