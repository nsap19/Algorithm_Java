package baekjoon_step1;

import java.util.Scanner;

public class Baekjoon2588 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a, b;
		int one, ten, hund;
		a = input.nextInt();
		b = input.nextInt();

		one = b % 10;
		ten = (b % 100 - one) / 10;
		hund = b / 100;

		System.out.println(a * one);
		System.out.println(a * ten);
		System.out.println(a * hund);
		System.out.println(a * b);

	}
}
