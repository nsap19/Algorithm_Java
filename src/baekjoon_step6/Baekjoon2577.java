package baekjoon_step6;

import java.util.Scanner;

public class Baekjoon2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int result = a * b * c; //세 수의 곱한 값

        String s_result = Integer.toString(result); //숫자를 문자열로 변환한 후
        String[] array = s_result.split(""); //자릿값마다 나눠서 배열로 초기화
        int[] intarr = new int[array.length]; // 위의 배열값은 각자 문자열이기 때문에 정수형으로 변환할 배열 선언


        int[] result_arr = new int[10]; //각 숫자가 몇번씩 나오는지에 대한 값이 들어갈 배열 - 최종적으로 출력해야할 것


        for (int i = 0; i < array.length; i++) { //array 배열값을 정수형으로 변환
            intarr[i] = Integer.parseInt(array[i]);
        }

        for (int i = 0; i < 10; i++) { //각 배열에서 숫자가 몇번씩 나오는지 세어보는 반복문
            for (int j = 0; j < array.length; j++) {
                if (i == intarr[j]) {
                    result_arr[i] += 1;
                }
            }
        }

        for (int i = 0; i < result_arr.length; i++) { //결과값 출력
            System.out.println(result_arr[i]);
        }
    }
}
