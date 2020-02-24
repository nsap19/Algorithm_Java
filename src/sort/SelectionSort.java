/* 선택정렬 - 전체 원소들 중에서 기준 위치에 맞는 원소를 선택하여 그 기준 위치에 저장하는 방식으로 정렬 */
/* 시간복잡도 O(n^2) */
package sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {69, 10, 30, 2, 16, 8, 31, 22};

        selectionSort(arr);

        System.out.println("result");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int temp = arr[i]; //최솟값
            int index = i; //최솟값이 있는 인덱스값
            for (int j = i + 1; j < arr.length; j++) {
                if (temp > arr[j]) {
                    temp = arr[j];
                    index = j;
                }
            }
            arr[index]= arr[i];
            arr[i]=temp;

            //과정마다 결과 보기
            for (int j = 0; j < arr.length ; j++) {
                System.out.print(arr[j]+" ");
            }
            System.out.println();
        }
    }

}
