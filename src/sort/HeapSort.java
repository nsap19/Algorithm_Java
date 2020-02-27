/*  힙 정렬 - 최대 힙에서는 항상 최대 원소가 루트 노드, 힙에 삭제 연산을 수행하면 항상 최대 원소를 삭제하여 리턴, 따라서 최대 힙에 대해 원소의 갯수만큼 삭제 연산을 수행하면 정렬이 이루어진다. */
/* 시간복잡도 O(n log2n) */
package sort;

public class HeapSort {
    public static void main(String[] args) {
        int[] a = {69, 10, 30, 2, 16, 8, 31, 22};
        int[] arr = new int[9];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = a[i - 1];
        }

        heapSort(arr);

        System.out.println("result");
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void heapSort(int[] a) {
        int n = a.length - 1;
        for (int i = n / 2; i >= 1; i--) { //배열 a[]를 히프로 변환
            makeHeap(a, i, n);
        }
        System.out.println("초기상태 최대 힙");
        for (int j = 1; j < a.length; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("\n");

        for (int i = n - 1; i >= 1; i--) { //히프의 루트 노드 원소를 배열의 비어있는 마지막 자리에 저장
            int temp = a[1];
            a[1] = a[i + 1];
            a[i + 1] = temp;
            makeHeap(a, 1, i);

            for (int j = 1; j < a.length; j++) {
                if(j==i) System.out.print("[ ");
                System.out.print(a[j] + " ");
                if(j==a.length-1) System.out.print("] ");
            }
            System.out.println();
        }
    }

    /* 최대 힙 구성하는 함수 */
    public static void makeHeap(int[] a, int h, int m) { //h는 부모노드, m은 총 노드 갯수
        int i;
        int item = a[h];
        for (i = 2 * h; i <= m; i = i * 2) { // i는 h의 자식노드

            if (i < m) {  //i==m인 경우는 자식노드가 없는 경우
                if (a[i] < a[i + 1]) i += 1; //같은 깊이의 자식노드 중에 더 큰수를 찾음
            }

            if (a[h] >= a[i]) break; //부모노드와 비교
            else a[i / 2] = a[i]; //부모노드[h]보다 자식노드[i]가 작다면 값 서로 변경(i/2 ==h, i==2*h)
        }
        a[i / 2] = item;
    }
}
