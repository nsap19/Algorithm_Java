package baekjoon_step8;

import java.util.Scanner;

public class Baekjoon10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        for (Character i = 'a'; i <= 'z'; i++) {
            System.out.print(s.indexOf(i) + " "); // 문자열.indexOf(문자) : 해당 문자가 들어있는 위치를 알려 줌(문자가 없으면 -1 반환)
        }
    }
}
