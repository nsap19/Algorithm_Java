package etc.programmers_Lv2;

import java.util.Stack;

public class Programmers_Lv2_13 {
    public static void main(String[] args) {
        System.out.println("case 1 : " + solution("(()())()"));
        System.out.println("expect : " + "(()())()");
        System.out.println("case 2 : "+solution(")("));
        System.out.println("expect : "+"()");
        System.out.println("case 3 : " + solution("()))((()"));
        System.out.println("expect : "+"()(())()");
    }

    public static String solution(String p) {
        String answer = "";

        if (rightCheck(p)) return p;
        answer = step1(p);

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

    private static boolean balanceCheck(String p) { //균형잡힌 괄호 문자열 체크
        int x = 0, y = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') x++;
            else y++;
        }
        if (x == y) return true;
        else return false;
    }

    private static String step1(String p) { //입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if (p.equals("")) return "";
        return step2(p);
    }

    private static String step2(String p) {
        //문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        String u = "";
        String v = "";
        for (int i = 0; i < p.length(); i++) {
            u += p.charAt(i);
            if (balanceCheck(u)) break;
        }
        v = p.substring(u.length());
//        System.out.println(u);
//        System.out.println(v);

        return step3(u,v);
    }

    private static String step3(String u, String v) { //문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        if (rightCheck(u)) {
            String result = step1(v);
            // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            return u+result;
        }
        else return step4(u,v);
        //문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
    }

    private static String step4(String u, String v){
        String result ="";

//        4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
        result +="(";

//        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
        result += step1(v);

//        4-3. ')'를 다시 붙입니다.
        result +=")";

//        4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        u = u.substring(1, u.length()-1);
        for (int i = 0; i < u.length() ; i++) {
            if(u.charAt(i)=='(') result+=")";
            else result+="(";
        }

//        4-5. 생성된 문자열을 반환합니다.
        return result;
    }


}
