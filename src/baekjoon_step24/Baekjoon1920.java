/* 이분탐색 : 이미 정렬이 되어 있는 자료구조에서 특정 값을 찾을 때에 탐색 범위를 절반씩 나눠가면서 해당 값을 찾아가는 것
* 주어진 자료구조의 탐색범위 중간값(mid)과 찾고자하는 값(num)을 비교하여
* num < mid이면 mid의 앞부분을 탐색하고
* num > mid이면 mid의 뒷부분을 탐색하며 범위를 좁혀감. */
package baekjoon_step24;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            bw.write(binaryTree(arr, num) + "\n");
        }
        bw.close();

    }

    private static int binaryTree(int[] arr, int num) { //num은 찾고자 하는 수
        int first = 0;
        int last = arr.length - 1;
        int mid = 0;

        while (first <= last) {
            mid = (first + last) / 2;

            if (num == arr[mid]) return 1;
            else {
                if (arr[mid] > num) last = mid - 1;
                else first = mid + 1;
            }
        }

        return 0;
    }
}
