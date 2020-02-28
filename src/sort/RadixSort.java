/* 기수 정렬 - 원소 키 값의 기수를 이용한 정렬 방법. 원소들을 각 원소의 키 값에 해당하는 버킷(bucket)에 분배하였다가 버킷의 순서대로 원소를 꺼내는 작업을 반복하여 정렬 */
/* 각각의 버킷을 큐로 구현 */
/* 시간복잡도 O(d(n+r)) */
/* 정렬할 원소의 수(n), 키 값의 자리수(d), 버킷의 수를 결정하는 기수(r)에 따라서 달라진다. */
package sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {69, 10, 30, 2, 16, 8, 31, 22};

        radixSort(arr);

        System.out.println("result");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    // 배열에서 최대값을 얻기 위한 메서드
    static int getMax(int[] a) {
        int mx = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > mx) {
                mx = a[i];
            }
        }
        return mx;
    }

    // exp 변수의 수에 따라 숫자를 정렬
    static void countSort(int[] a, int exp) {
        int[] output = new int[a.length];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // count 값 count배열에 저장
        for (int i = 0; i < a.length; i++) {
            count[(a[i] / exp) % 10]++;
        }
        // count 값이 포함시켜 count배열에 저장
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        // output배열 빌드
        for (int i = a.length - 1; i >= 0; i--) {
            output[count[(a[i] / exp) % 10] - 1] = a[i];
            count[(a[i] / exp) % 10]--;
        }
        // output 배열에 저장된 값을 a 배열에 저장
        for (int i = 0; i < a.length; i++) {
            a[i] = output[i];
        }
    }

    static void radixSort(int[] a) {
        // 최대값 찾기
        int m = getMax(a);
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(a, exp);
        }
    }

}
