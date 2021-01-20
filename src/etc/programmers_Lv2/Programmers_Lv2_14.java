package etc.programmers_Lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_Lv2_14 {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args){
        System.out.println(solution("1924", 2));
        System.out.println("94");
        System.out.println(solution("1231234",3));
        System.out.println("3234");
        System.out.println(solution("4177252841",4));
        System.out.println("775841");
    }

    public static String solution(String number, int k) {
        String answer = "";

        int n = number.length()-k;

        while(n>0){
            String u = number.substring(0, number.length()-n+1);

            int max = 0;
            int index = 0;
            for (int i = 0; i < u.length() ; i++) {
                if(max < u.charAt(i)-'0') {
                    max = u.charAt(i)-'0';
                    index = i;
                }

            }

            answer += String.valueOf(max);
            n--;
            number = number.substring(index+1);
        }


        return answer;
    }
}
