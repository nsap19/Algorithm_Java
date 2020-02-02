package baekjoon_step8;

import java.util.Scanner;
import java.util.stream.Stream;

public class Baekjoon11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String number = sc.next();
        int[] digits = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += digits[i];
        }

        System.out.println(sum);

    }
}
