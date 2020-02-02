package baekjoon_step8;

import java.util.Scanner;

public class Baekjoon11654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next(); //string으로 입력을 받음
        Character c = input.charAt(0); //string의 0번째값을 character형 변수로 변환
        System.out.println((int)c); //character를 int형으로 형변환 하면 아스키코드가 나옴
    }
}
