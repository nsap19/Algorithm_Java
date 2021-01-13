package etc.programmers_Lv2;

import java.io.*;
import java.util.Stack;

public class Programmers_Lv2_13 {
    public static void main(String[] args) {
//        System.out.println("case 1 : " + solution("(()())()"));
//        System.out.println("expect : " + "(()())()");
        System.out.println("case 2 : "+solution(")("));
//        System.out.println("expect : "+"()");
//        System.out.println("case 3 : "+solution("()))((()"));
//        System.out.println("expect : "+"()(())()");
    }

    public static String solution(String p) {
        String answer = "";

        if(rightCheck(p)) return p;
        String str ="";
        String u = "";
        for (int i = 0; i < p.length() ; i+=2) {
            str += p.substring(i,i+2);


//            System.out.println(str);
        }


        return answer;
    }

    private static boolean rightCheck(String p) { //올바른 괄호 문자열 체크
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') stack1.push('(');
            else if (p.charAt(i) == ')') {
                stack2.push(')');
                if (stack1.size() > 0) {
                    stack1.pop();
                    stack2.pop();
                }
            }
        }

        if (stack1.size() == 0 && stack2.size() == 0) return true;
        else return false;
    }

    private static boolean balanceCheck(String p){ //균형잡힌 괄호 문자열 체크
        int x=0, y=0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') x++;
            else y++;
        }
        if(x==y) return true;
        else return false;
    }

    private static String step1(String p){ //입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(p.equals("")) return "";
        else return p;
    }

//    private static String[] step2(String p){ //문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
//
//    }
}
