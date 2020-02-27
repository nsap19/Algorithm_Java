/*  퀵 정렬 - 기준값을 중심으로 왼쪽부분과 오른쪽 부분으로 분할한 후, 이 두 부분을 따로 정렬하여 모으는 방식으로 정렬한다.
 * 분활 과정에서 왼쪽부분에는 기준값보다 작은 원소들을 이동시키고, 오른쪽 부분에는 기준값보다 큰 원소들을 이동시킨다. */
/* 시간복잡도 O(n log2n) */
package sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {69, 10, 30, 2, 16, 8, 31, 22};

        quickSort(arr, 0, arr.length - 1);

        System.out.println("result");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) { //정렬할 원소가 2개 이상이면
            int p = partition(arr, begin, end); //p는 기준값 인덱스

            quickSort(arr, begin, p - 1); //기준값보다 작은부분 퀵소트
            quickSort(arr, p + 1, end); //기분값보다 큰 부분 퀵소트
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        int i = begin;
        int j = end + 1;

        do {
            do {
                i = i + 1;
            } while (i <= end && arr[i] < pivot); //피봇보다 작은값 찾기
            do {
                j = j - 1;
            } while (arr[j] > pivot); //피봇보다 큰값 찾기
            if (i < j) swap(arr, i, j); //큰값과 작은값 위치 바꾸기
        } while (i < j);

        swap(arr, begin, j); //피봇과 피봇보다 작은값 위치 바꾸기 = 피봇이 가운데로

        /*정렬 과정*/
        System.out.print("pivot="+pivot+" ");
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();
        return j;
    }

    private static void swap(int[] a, int i, int j) { //a[i]와 a[j]를 교환
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
