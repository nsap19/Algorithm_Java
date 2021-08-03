package etc.programmers_Lv2;

import java.util.Stack;

public class Programmers_Lv2_19 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));

    }

    private static int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            }
            else stack.push(s.charAt(i));
        }

        if(stack.size()==0) answer = 1;
        else answer=0;


        return answer;
    }
}
