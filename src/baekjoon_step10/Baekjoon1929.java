package baekjoon_step10;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); //범위최솟값
        int n = sc.nextInt(); //범위최댓값
        int sum = 0;
        ArrayList<Integer> sosoo = new ArrayList<>();

        for (int i = m; i <= n; i++) {
            int check = 0; //약수 쌍의 갯수

            for (int j = 1; j < i; j++) {
                if (i % j == 0) check++; // 소수는 자신보다 작은 두 개의 자연수를 곱하여 만들 수 없는 1보다 큰 자연수
            }
            if (i > 1 && check == 1) { //1보다 크고, 약수가 1과 자기자신인 경우 = 소수
                sosoo.add(i);
            }
        }

        for (int i = 0; i < sosoo.size(); i++) {
            sum += sosoo.get(i);
        }
        if (sosoo.size() == 0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(sosoo.get(0));
        }
    }
}
