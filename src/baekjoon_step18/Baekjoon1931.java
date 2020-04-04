package baekjoon_step18;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int temp = 0;
        int count = 1;


        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
            else return Integer.compare(o1[1], o2[1]);
        });

//        for (int i = 0; i < arr.length; i++) { //정렬된 배열 출력
//            System.out.println(arr[i][0] + " " + arr[i][1]);
//        }


        for (int i = 1; i < n; i++) {
            if (arr[temp][1] <= arr[i][0]) {
                temp = i;
                count++;
//                System.out.println(temp);
            }

        }

        bw.write(String.valueOf(count));
        bw.close();


    }
}