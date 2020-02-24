package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {69, 10, 30, 2, 16, 8, 31, 22};

        bubbleSort(arr);

        System.out.println("result");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
            for (int j = 0; j < arr.length ; j++) {
                System.out.print(arr[j]+" ");
            }
            System.out.println();
        }
    }

    private static void swap(int[] a, int i, int j){ //a[i]와 a[j]를 교환
        int temp = a[i];
        a[i]= a[j];
        a[j]=temp;
    }
}
