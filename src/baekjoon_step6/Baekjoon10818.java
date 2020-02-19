package baekjoon_step6;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int[] arr = new int[a];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

//        /* 시간초과 */
//        for(int i=0; i<arr.length; i++){
//            for(int j=0; j<arr.length; j++){
//                if(arr[j]<arr[i]){
//                    int temp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = temp;
//                }
//            }
//        }

        Arrays.sort(arr);

        System.out.print(arr[0]+" ");//최솟값
        System.out.print(arr[arr.length - 1]);//최댓값
    }
}
