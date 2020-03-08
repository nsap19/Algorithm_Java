//i번째 집을 각각의 색으로 칠할 때, 1~i번째 집을 모두 칠하는 최소 비용으로 부분문제를 정의해봅시다.
package baekjoon_step16;

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] RGB = new int[n][3];


        for (int i = 0; i < n; i++) { //집의 수만큼 반복
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) { //각 색의 비용
                RGB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(RGB[i][j]+" ");
//            }
//            System.out.println();
//        }

        for (int i = 1; i < n; i++) { //자신의 값에 이전 집의 최솟값을 더함
            RGB[i][0] += Math.min(RGB[i - 1][1], RGB[i - 1][2]);
            RGB[i][1] += Math.min(RGB[i - 1][0], RGB[i - 1][2]);
            RGB[i][2] += Math.min(RGB[i - 1][0], RGB[i - 1][1]);
        }

        Arrays.sort(RGB[n - 1]);

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(RGB[i][j]+" ");
//            }
//            System.out.println();
//        }
        bw.write(String.valueOf(RGB[n - 1][0])); //정렬한 RGB[n-1]의 값중 최솟갑 출력
        bw.close();
    }

}
