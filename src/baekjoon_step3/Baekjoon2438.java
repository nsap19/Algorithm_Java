package baekjoon_step3;

import java.util.Scanner;

public class Baekjoon2438 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();

        for(int i = 0 ; i< t; i++){
            for(int j = 0 ; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();

        }
    }
}
