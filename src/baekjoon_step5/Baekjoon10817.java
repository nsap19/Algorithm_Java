package baekjoon_step5;

import java.util.Scanner;

public class Baekjoon10817 {

//	세 정수 A, B, C가 주어진다. 이때, 두 번째로 큰 정수를 출력하는 프로그램을 작성하시오.

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);

        int[] arr = new int[3];
        int temp;

        for(int i = 0 ; i< arr.length; i++){
            arr[i] = input.nextInt();
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

            System.out.println(arr[1]);




    }

}
