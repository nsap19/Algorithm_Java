package baekjoon_step7;

import java.util.ArrayList;
import java.util.Iterator;

public class Baekjoon4673 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(); //생성자가 있는 숫자들(!셀프넘버)을 저장
        ArrayList<Integer> selfnumbers = new ArrayList<>(); //셀프넘버를 저장


        for (int n = 0; d(n) < 10000; n++) { //이 부분이 틀린 것
            while (true) {
                numbers.add(d(n));

                if (d(n) < 10000) {
                    break;
                }
            }
        }

        numbers.sort(null);

        for (int value : numbers) {
            System.out.print(value+" ");
        }
        System.out.println();

        for (int i = 1; i < 10000; i++) {
            if (!numbers.contains(i)) {
                selfnumbers.add(i);
            }
        }
        selfnumbers.sort(null);

        for (int value : selfnumbers) {
            System.out.print(value+" ");
        }


    }

    static int d(int n) {
        /*내가 짠 코드
        String str = String.valueOf(n); //n을 spilt 하기위해 string 형변환
        String[] str_arr = str.split(""); // n을 split하여 나온 배열
        int[] n_split = new int[str.length()]; //str_arr의 int값으로 넣을 배열
        int sum = n; //d(n)의 최종 값

        for (int i = 0; i < n_split.length; i++) {
            n_split[i] = Integer.parseInt(str_arr[i]);
            sum += n_split[i];
        }

        return sum;*/

        int dn = n;
        while (n > 0) {
            dn += n % 10;
            n /= 10;
        }
        return dn;
    }
}
