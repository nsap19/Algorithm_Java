package baekjoon_step10;

import java.util.Scanner;

public class Baekjoon3053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextInt();

        System.out.println(String.format("%.6f", Math.PI * a * a)); //유클리드 기하학에서 원의 넓이 = pi*R^2
        System.out.println(String.format("%.6f", 2 * a * a)); //택시 기하학에서 원의 넓이 = 2*R^2
    }
}
