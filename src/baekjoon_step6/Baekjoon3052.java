package baekjoon_step6;

import java.util.Scanner;

public class Baekjoon3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        int[] remain = new int[10];
        int[] result = new int[42];


        int count = 0;

        for (int i = 0; i < arr.length; i++) { //입력받은 값으로 arr배열 생성
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            remain[i] = arr[i] % 42;
//            System.out.println(remain[i]);
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < remain.length; j++) {
                if (i == remain[j]) {
                    result[i] += 1;
                }
            }
        }

        for (int i=0; i<result.length;i++) {
            if(result[i] != 0){
                count++;
            }
        }

        System.out.println(count);

    }
}
