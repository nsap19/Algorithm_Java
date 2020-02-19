package baekjoon_step9;

import java.util.Scanner;

public class Baekjoon10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); //테스트케이스
        int[] result = new int[t];

        for (int i = 0; i < t; i++) {
            int h = sc.nextInt(); //호텔의 층 갯수
            int w = sc.nextInt(); //한층에 있는 방의 개수
            int n = sc.nextInt(); //n번째 손님
            int xx = 1;
            int yy = 1;
            int count = 1;

            while (count < n) {
                xx++;
                count++;
                if (xx > h) {
                    xx = 1;
                    yy++;
                }
            }
            result[i] = xx * 100 + yy;
        }
        for (int value : result) {
            System.out.println(value);
        }
    }
}
