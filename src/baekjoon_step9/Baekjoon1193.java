package baekjoon_step9;

import java.util.Scanner;

// 1/1 => 1
// 1/2 -> 2/1 =>2
// 3/1 -> 2/2 -> 1/3 =>3
// 1/4 -> 2/3 -> 3/2 -> 4/1 =>4
// 5/1 -> 4/2 -> 3/3 -> 2/4 -> 1/5 =>5

//짝수층일땐 a++,b-- / b=1이면 layer+1
//홀수층일때 a--,b++ / a=1이면 layer+1

public class Baekjoon1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int count = 1;
        int a = 1; //분자
        int b = 1; //분모
        int layer = 1;

        while (count < x) {
            if (layer % 2 == 0) { // 층이 짝수일 때
                if (b == 1) {
                    layer++;
                    a++;
                    count++;
                } else {
                    a++;
                    b--;
                    count++;
                }

            } else if (layer % 2 == 1) { //층이 홀수 일 때
                if (a == 1) {
                    layer++;
                    b++;
                    count++;
                } else {
                    a--;
                    b++;
                    count++;
                }
            }
//            System.out.println(a + "/" + b + " =" + count + " layer:" + layer);

        }


        System.out.println(a + "/" + b);

    }
}

