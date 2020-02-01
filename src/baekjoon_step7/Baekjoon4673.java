package baekjoon_step7;

import java.util.Scanner;

public class Baekjoon4673 {
    public static void main(String[] args) {
        for (int n = 0; d(n) <10000 ; n++) {
            while (true) {
                System.out.println(d(n));
                if (d(n) < 10000) {
                    break;
                }
            }
        }

    }

    static int d(int n) {
        String str = String.valueOf(n); //n을 spilt 하기위해 string 형변환
        String[] str_arr = str.split(""); // n을 split하여 나온 배열
        int[] n_split = new int[str.length()]; //str_arr의 int값으로 넣을 배열
        int sum = n; //d(n)의 최종 값

        for (int i = 0; i < n_split.length; i++) {
            n_split[i] = Integer.parseInt(str_arr[i]);
            sum += n_split[i];
        }

        return sum;
    }
}
