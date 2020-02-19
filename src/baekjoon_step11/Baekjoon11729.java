/* 원반이 n개 일때
1번 기둥에 있는 n-1개 원반을 2번 기둥에 옮긴다. -1
1번 기둥에 가장 큰 원반을 3번 기둥으로 옮긴다. -2
2번 기둥에 있는 n-1개 원반을 3번 기둥으로 옮긴다. -3
 */
package baekjoon_step11;

import java.util.Scanner;

public class Baekjoon11729 {
    public static int count = 0;
    public static StringBuilder result = new StringBuilder(); //그냥 string으로 연산하면 시간초과가 뜨기때문에 stringbuilder를 사용


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //원판의 갯수
        hanoi(n, 1, 2, 3);
        result.insert(0, count+"\n");
        System.out.println(result);

    }

    public static void hanoi(int n, int from, int by, int to) {
        if (n == 1) { // -2
            count++;
            result.append(from + " " + to + "\n");
        } else {
            hanoi(n - 1, from, to, by); // -1
            result.append(from + " " + to + "\n");
            count++;
            hanoi(n - 1, by, from, to); // -3
        }
    }
}
