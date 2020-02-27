/*  병합 정렬 - 정렬된 자료 집합들을 하나로 병합하는 방식으로 정렬한다. */
/* 시간복잡도 O(n log2n) */
package sort;

public class MergeSort {
    private static int[] result = new int[8];

    public static void main(String[] args) {
        int[] arr = {69, 10, 30, 2, 16, 8, 31, 22};

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("result");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr, int lb, int ub) {
        int middle = (lb + ub) / 2;
        if (lb < ub) { //정렬할 원소가 두개 이상이면
            mergeSort(arr, lb, middle); //arr[lb...middle]을 병합 정렬
            mergeSort(arr, middle + 1, ub); //arr[middle+1 ...ub]을 병합 정렬
            merge(arr, lb, middle, ub); //arr[lb..middle]과 arr[middle+1..ub]를 병합
        }
    }

    private static void merge(int[] arr, int lb, int middle, int ub) {
        int i = lb;             // 첫 번째 부분집합의 시작 위치 설정
        int j = middle + 1;     // 두 번째 부분집합의 시작 위치 설정
        int k = lb; //result에 비교 후 채워야하는 인덱스 값

        while (i <= middle && j <= ub) {
            if (arr[i] <= arr[j]) result[k] = arr[i++];
            else result[k] = arr[j++];
            k++;
        }

        if (i > middle) { //middle 앞부분이 먼저 정렬 완료 되었을 때,나머지 j가 정렬 안된 부분부터 ub까지 그대로 result에 값 삽입
            for (int l = j; l <= ub; l++, k++)
                result[k] = arr[l];
        } else { //middle 뒷부분이 먼저 정렬 완료 되었을 때, 나머지 i가 정렬 안된 부분부터 middle까지 그대로 result에 값 삽입
            for (int l = i; l <= middle; l++, k++)
                result[k] = arr[l];
        }

        //그다음 비교를 위해 arr에 새롭게 정렬된 result배열의 값을 저장
        for (int l = lb; l <= ub; l++) {
            arr[l] = result[l];
        }

        /*정렬 과정 출력 */
        for (int l = 0; l < arr.length; l++) {
            if(l==lb) System.out.print("[ ");
            System.out.print(arr[l] + " ");
            if(l==middle) System.out.print("| ");
            if(l==ub) System.out.print("] ");
        }
        System.out.println();
    }


}
