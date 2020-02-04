package baekjoon_step8;

import java.util.Scanner;

public class Baekjoon1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] words = s.split(" ");
        int count = 0;

        for (int i = 0; i < words.length; i++) {
//            if (!words[i].isBlank()) { //java 11에서는 가능. 일반 java(java8)에서는 사용할수 없는 메소드라 컴파일 에러
            if(!words[i].isEmpty()){
                count++;
            }
        }
        System.out.println(count);
    }
}
