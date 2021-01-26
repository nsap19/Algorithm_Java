package etc.programmers_Lv2;

import java.util.ArrayList;

public class Programmers_Lv2_14 {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args){
//        System.out.println(solution("1924", 2));
//        System.out.println("94");
//        System.out.println(solution("1231234",3));
//        System.out.println("3234");
//        System.out.println(solution("4177252841",4));
//        System.out.println("775841");
    }

    //나의 풀이
    public static String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        int n = number.length()-k;

        while(n>0){
            String u = number.substring(0, number.length()-n+1);

            int max = -1;
            int index = 0;
            for (int i = 0; i < u.length() ; i++) {
                if(max < u.charAt(i)-'0') {
                    max = u.charAt(i)-'0';
                    index = i;
                    if(max==9) break;
                }
            }

            sb.append(max);
//            answer += String.valueOf(max);
            n--;
            number = number.substring(index+1);
        }

        answer = sb.toString();
        return answer;
    }

    //다른 사람의 풀이
//    public String solution(String number, int k) {
//        char[] result = new char[number.length() - k];
//        Stack<Character> stack = new Stack<>();
//
//        for (int i=0; i<number.length(); i++) {
//            char c = number.charAt(i);
//            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
//                stack.pop();
//            }
//            stack.push(c);
//        }
//        for (int i=0; i<result.length; i++) {
//            result[i] = stack.get(i);
//        }
//        return new String(result);
//    }
}
