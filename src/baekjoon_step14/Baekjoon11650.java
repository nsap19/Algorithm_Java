package baekjoon_step14;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[][] temp = new int[1][1];

        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        /* Arrays.sort의 comparator함수를 수정하는 방식 */
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]); //첫번째 element가 같다면 두번째 element를 비교
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        /* 참고 : https://ramees.tistory.com/53 */

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");
        }
        bw.close();
    }
}
