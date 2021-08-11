package etc.programmers_Lv2;

import java.util.Stack;

public class Programmers_Lv2_25 {
    public static void main(String[] args) {
//        System.out.println(solution("[](){}")); //3
//        System.out.println(solution("}]()[{")); //2
//        System.out.println(solution("[)(]")); //0
        System.out.println(solution("}}}")); //0
    }

    private static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        int start, count = 0;
        for (int i = 0; i < s.length(); i++) { //s-1번 회전하기
            start = i;
            boolean check = true;
            int index = start;
            for (int j = 0; j < s.length(); j++, index++) { //s길이만큼 문자열 조회
                if (index == s.length()) index = 0;
                char c = s.charAt(index);
                if (c == '[' || c == '{' || c == '(') stack.push(c);

                else if (stack.isEmpty()) {
                    check = false;
                    break;
                } else if (c == ']') {
                    if (stack.peek() == '[') stack.pop();
                    else {
                        check = false;
                        break;
                    }
                } else if (c == '}') {
                    if (stack.peek() == '{') stack.pop();
                    else {
                        check = false;
                        break;
                    }
                } else if (c == ')') {
                    if (stack.peek() == '(') stack.pop();
                    else {
                        check = false;
                        break;
                    }
                }
            }
            if (check && stack.size()==0) count++;
        }
        return count;
    }
}
