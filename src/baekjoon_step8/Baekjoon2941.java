package baekjoon_step8;

import java.util.Scanner;

public class Baekjoon2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ca = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String input = sc.next();
        int count = 0;
        int len = input.length();

        for (int j = 0; j < ca.length; j++) { //크로아티아 알파벳을 A로 대체하여 변경하여 최종 문자열의 길이를 구
            input = input.replace(ca[j], "A");
        }
        System.out.println(input.length());
    }
}
