package baekjoon_step10;

import java.util.Scanner;

public class Baekjoon3009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        int x;
        int y;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        x = (arr[0] == arr[2] ? arr[4] : (arr[0] == arr[4]) ? arr[2] : arr[0]);
        y = (arr[1] == arr[3] ? arr[5] : (arr[1] == arr[5]) ? arr[3] : arr[1]);


        System.out.println(x + " " + y);

    }
}
