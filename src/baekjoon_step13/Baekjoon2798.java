/* 비교대상 m, sum, temp
 * m과 sum을 비교하는 조건문
 * temp와 sum을 비교하는 조건문이 각각 존재해야함 */
package baekjoon_step13;

import java.util.Scanner;

public class Baekjoon2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //카드의 갯수
        int m = sc.nextInt(); //넘지 말아야 하는 수
        int[] arr = new int[n];
        int sum = 0;
        int temp = 0; //전 단계를 비교하기 위한 임시변수


        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        loop1:
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    sum = arr[i] + arr[j] + arr[k];
                    if (sum == m) break loop1;
                    if (sum < m && temp <= sum) temp = sum;
                    else sum = temp;
                    /* sum > m && temp > sum
                    * sum > m  의 경우가 else에 해당 */
                }

            }
        }
        System.out.println(sum);
    }
}
