/* 계단 오르기 문제의 조건
* 1. 계단을 오를때는 1칸 또는 2칸까지 한번에 오를수있다.
* 2. 연속된 3칸은 오를 수 없다.
* 3. 마지막 계단은 무조건 밟아야한다. */

/* 마지막 계단을 무조건 밟아야한다면 두가지로 분류할 수 있다.
1. 전칸을 밟고 마지막칸을 밟는 경우 : n-1 + n
2. 전전칸을 밟고 마지막칸을 밟는 경우 : n-2 + n

하지만 1번의 경우 연속으로 3칸을 밟을 수 없으므로 전칸을 밟고 현재칸을 밟는경우에는 조건을 추가해주어야한다.
1. 전칸을 밟는 경우에는 n-2번째 칸을 밟을 수 없다. : n-3 + n-1 + n */

package baekjoon_step16;

import java.io.*;

public class Baekjoon2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] stair = new long[n];
        long[] score = new long[n]; //i번째 계단까지 갔을 때 나올 수 있는 최댓값

        for (int i = 0; i < n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        score[0] = stair[0];
        if (n > 1) score[1] = Math.max(stair[1], stair[0] + stair[1]);
        if (n > 2) score[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);

        for (int i = 3; i < n; i++) {
            score[i] = Math.max(score[i - 2] + stair[i], score[i - 3] + stair[i - 1] + stair[i]);
        }

        bw.write(String.valueOf(score[n - 1]));
        bw.close();
    }

}
