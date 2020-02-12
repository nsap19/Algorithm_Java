package baekjoon_step10;

import java.util.Scanner;

public class Baekjoon1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result = "";

        int t = sc.nextInt(); //테스트케이스
        for (int i = 0; i < t; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            double len = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); //두 점 사이의 거리
            if (x1 == x2 && y1 == y2) { //두 점의 위치가 같을때
                if (r1 == r2) result += "-1\n"; //두 원이 같으면 겹치는 점의 갯수가 무한대
                else result += "0\n"; //점의 위치는 같지만 크기가 다르다면 겹치는 점이 없음
            } else { //두 점의 위치가 다를때
                if (len > r1 + r2 || len < Math.abs(r1 - r2)) result += "0\n"; //두 원이 멀리 떨어져 있거나 원안에 원이 있을 때
                else if (len == r1 + r2 || len == Math.abs(r1 - r2)) result += "1\n"; //두 원이 바로 붙어있거나 원안의 원이 큰원 한쪽에 붙어있을 때
                else if (len < r1 + r2) result += "2\n"; //두 원이 겹쳐져 있을 때
            }
        }
        System.out.println(result);

    }
}
