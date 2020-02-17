package baekjoon_step13;

import java.util.Scanner;

public class Baekjoon1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int temp = 0;
        int count = 0;
        int i = 666;

        while (count < n) {
            if (Integer.toString(i).contains("666")) {
                if (temp < i) {
                    temp = i;
                    count++;
                }

            }
            i++;
        }

        System.out.println(temp);
    }
}
