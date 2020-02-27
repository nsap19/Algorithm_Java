/*  셸 정렬 - 일정한 간격(interval)으로 떨어져있는 원소들을 부분집합으로 하여 이 부분 집합에 대해서 "삽입 정렬"을 수행하고, 이 과정을 반복하여 전체 원소들을 정렬하는 방법 */
/* 시간복잡도 O(n^1.25)로 측정 */
package sort;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {69, 10, 30, 2, 16, 8, 31, 22};
        shellSort(arr, arr.length);
    }

    public static void shellSort(int a[], int size) {
        int interval = size / 2;
        int t = 0; //단계를 나타내기 위한 변수

        while (interval >= 1) {
            for (int i = 0; i < interval; i++)
                intervalSort(a, i, size - 1, interval);

            /* 정렬 과정 출력 */
            System.out.printf("셸정렬 %d단계 : interval=%d [ ", ++t, interval);
            for (int i = 0; i < size; i++) System.out.print(a[i] + " ");
            System.out.print("] \n");

            interval /= 2;
        } //while문 끝
    }

    /* 이 부분을 swap함수를 이용해 구현해봤지만 시간이 굉장히 오래 걸렸음. */
    public static void intervalSort(int a[], int begin, int end, int interval) {
        int j, item;
        for (int i = begin + interval; i <= end; i += interval) {
            item = a[i]; //뒤에 있는 비교할 수
            for (j = i - interval; j >= begin && item < a[j]; j -= interval) // 뒤(a[i]) < 앞(a[j]) 일때 교환
                a[j + interval] = a[j];  //a[j+interval] == a[i] (뒤에 있는 수) ==> 앞 뒤 숫자를 교환
            a[j + interval] = item; //for문을 마치고 나온 j=j-interval(j+interval==j) / for문에 해당이 되지 않은 경우 j의 값은 변함없음(j+interval==i)
        }
    }
}
