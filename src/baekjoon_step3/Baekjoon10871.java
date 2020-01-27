package baekjoon_step3;

import java.util.Scanner;

public class Baekjoon10871 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); //주어져야 할 수열의 정수 갯수
        int x = input.nextInt(); //수열중의 x보다 작은 수를 골라내야함
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        for (int j = 0; j < n; j++) {
            if (arr[j] < x) {
                System.out.print(arr[j]+" ");
            }
        }
    }
}
