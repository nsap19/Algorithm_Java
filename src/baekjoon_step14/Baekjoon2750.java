/* 삽입 정렬
* 시간 복잡도 O(n^2)*/
package baekjoon_step14;

import java.util.Scanner;

public class Baekjoon2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int temp;
            for (int j = i - 1; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
                arr[j] = key;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
