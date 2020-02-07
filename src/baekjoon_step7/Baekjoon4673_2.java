package baekjoon_step7;

import java.util.ArrayList;

public class Baekjoon4673_2 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(); //생성자가 있는 숫자들(!셀프넘버)을 저장 - d(n)을 돌렸을 때 나오는 것,n이 있는 값
        ArrayList<Integer> selfnumbers = new ArrayList<>(); //셀프넘버를 저장 - d(n) 함수 결과에서 나오지 않은 수


        for (int n = 0; n < 10000; n++) { //생성자가 있는 숫자들을 구하여 numbers에 추가
                if (d(n) < 10000) {
                    numbers.add(d(n));
                }
        }

        for (int i = 1; i < 10000; i++) { //1~10000까지 수 중 numbers에 없는 숫자를 selfnumber에 추가
            if (!numbers.contains(i)) {
                selfnumbers.add(i);
            }
        }
        selfnumbers.sort(null); //오름차순으로 정렬

        for (int value : selfnumbers) { //selfnumbers 출력
            System.out.println(value);
        }


    }

    static int d(int n) {
        int dn = n;
        while (n > 0) { //입력받은 수의 자릿수별로 덧셈
            dn += n % 10;
            n /= 10;
        }
        return dn;
    }
}
