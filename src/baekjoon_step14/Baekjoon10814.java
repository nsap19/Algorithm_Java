package baekjoon_step14;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken(); //나이
            arr[i][1] = st.nextToken(); //이름
        }

        /* Arrays.sort의 comparator함수를 수정하는 방식 */
        Arrays.sort(arr, (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
        });

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");
        }
        bw.close();

    }
}
