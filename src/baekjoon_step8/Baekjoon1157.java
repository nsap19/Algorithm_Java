package baekjoon_step8;

import java.util.Scanner;

public class Baekjoon1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next().toUpperCase(); //A~Z = 65~90
        int[] atoz = new int[26];
        int max = 0;
        char result = '?';

        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 65;
            atoz[j]++;

            if (atoz[j] > max) {
                max = atoz[j];
                result = word.charAt(i);
            } else if (atoz[j] == max) {
                result = '?';
            }
        }
        System.out.println(result);
    }
}
