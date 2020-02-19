package baekjoon_step8;

import java.util.Scanner;

public class Baekjoon2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();//테스트 케이스
        String p = ""; //출력할 문자열

        for (int i = 0; i < t; i++) {
            int r = sc.nextInt(); // 문자 반복 횟수
            String s = sc.next(); // 반복할 문자열

            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k < r; k++) {
                    p+=s.charAt(j); //한 문자에 대해서 r번 반복
                }
            }
            p+=" \n"; //각 결과값마다 줄바꿈을 해야하기 때문에 추가
        }
        System.out.println(p);
    }
}

