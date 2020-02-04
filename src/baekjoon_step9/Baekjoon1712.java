package baekjoon_step9;

import java.util.Scanner;

public class Baekjoon1712 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(); //고정비용
        int b = sc.nextInt(); //노트북 1대 생산하는데에 드는 가변비용
        int c = sc.nextInt(); //노트북 1대 판매가
        int n=1; //노트북 갯수

        while (true){
            if(b >= c){
                n = -1;
                break;
            }

            if(a/(c-b) < n){
                break;
            }
            n++;
        }
        System.out.println(n);
    }
}
