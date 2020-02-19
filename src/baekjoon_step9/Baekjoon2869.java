package baekjoon_step9;

import java.util.Scanner;

public class Baekjoon2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(); //낮에 올라가는 높이
        int b = sc.nextInt(); //밤에 내려오는 높이
        int v = sc.nextInt(); //나무의 총높이
        int day; //정상에 올라가는데에 걸리는 날


        day = (v - b) / (a - b);
        if ((v - b) % (a - b) > 0) day++;

        System.out.println(day);

    }
}
