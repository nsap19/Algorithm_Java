/* 삽입 정렬 - 이미 정렬되어있는 부분에 새로운 원소의 위치를 찾아 삽입하는 방식으로 정렬한다. */
/* 시간복잡도 O(n^2) */
package sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {69, 10, 30, 2, 16, 8, 31, 22};

        insertionSort(arr);

        System.out.println("result");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void insertionSort(int[] arr) {
        int temp = 0;
        int index =0;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (int j = i; j > 0 && arr[j - 1] > temp; j--) { //정렬된 구간(0~i)중에 temp가 들어갈 위치(j)를 찾음
                arr[j] = arr[j-1];
                index = j-1;
            }
            arr[index] = temp;

            //실행과정 출력
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }


}
