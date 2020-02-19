package baekjoon_step6;

import java.util.Scanner;

public class Baekjoon2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];
        int p=0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[p] < arr[i]){
                p = i;
            }
        }
        System.out.println(arr[p]);
        System.out.println(p+1);
    }
}
