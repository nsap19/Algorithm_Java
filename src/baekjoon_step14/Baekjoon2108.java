/* 평균값, 중앙값(중간의 크기), 최빈값(가장 많이 나온 수, 여러개가 있다면 두번째로 작은 수), 최댓값과 최솟값의 차이 */
package baekjoon_step14;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Baekjoon2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int avg = 0;
        int[] count = new int[80001]; //음수, 양수로 절대값이 4000 + 0
        int temp = 0;
        ArrayList<Integer> most = new ArrayList<>();

        /* 입력과 동시에 평균값을 구함 */
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            avg += arr[i];
        }
        Arrays.sort(arr);

        /* 산술평균 & 중앙값 */
        bw.write(Math.round((double) avg / n) + "\n"); //소수점 첫째자리에서 반올림
        bw.write(arr[n / 2] + "\n");

        /* 최빈값 */
        for (int i = 0; i < arr.length; i++) { //최빈값을 구하기 위한 숫자의 등장 횟수 세기
            count[arr[i] + 4000]++; //입력받은 값이 양수일 때
        }

        for (int i = 0; i < count.length; i++) {
            if (temp <= count[i]) {
                if (temp < count[i]) {
                    temp = count[i];
                    most.clear();
                    most.add(i);
                } else most.add(i); //최빈값이 여러개일 때
            }
        }

        if (most.size() > 1) { //최빈값이 여러개일 때
            Collections.sort(most);
            bw.write(most.get(1) - 4000 + "\n"); //두번째로 작은 값
        } else bw.write(most.get(0) - 4000 + "\n");

        /* 범위 */
        bw.write(arr[arr.length - 1] - arr[0] + "\n");

        bw.close();
    }


}
