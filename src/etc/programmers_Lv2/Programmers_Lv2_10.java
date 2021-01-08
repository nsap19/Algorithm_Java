package etc.programmers_Lv2;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Programmers_Lv2_10 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution("17"));

    }

    public static int solution(String numbers) {
        int answer = 0;

        String[] numArr = numbers.split("");
        Arrays.sort(numArr, Collections.reverseOrder());
        String maxStr = "";
        for (int i = 0; i < numArr.length; i++) maxStr += numArr[i];

        int max = Integer.parseInt(maxStr);
        int min = Integer.parseInt(numArr[numArr.length-1]);
        boolean[] nums = new boolean[max+1];

        //에라토스테네스의 체를 이용하여 max까지의 소수들을 구함
        int temp = 0; //배수를 돌릴 기준 ex) 1~120이면 11*11 >120이기 때문에 11보다 작은 수의 배수들만 지워도 충분하다
        for (int i = 0; i < max; i++) {
            if (i * i <= max) temp = i + 1;
            else break;
        }

        for (int i = 2; i < temp; i++) {
            for (int j = 2; i * j <= max; j++) {
                nums[i * j] = true;
            }
        }

        for (int i = min; i <= max; i++) {
            if (i > 1 && nums[i] == false){
                String iStr = String.valueOf(i);
            }
        }

        return answer;
    }

}
