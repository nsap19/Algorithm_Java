package etc.programmers_Lv2;

public class Programmers_Lv2_22 {
    static char[] operator, per;
    static boolean[] visited;
    static String exp;
    static long max = 0;

    private static long solution(String expression) {
        exp = expression;
        operator = new char[]{'*', '+', '-'};
        visited = new boolean[3];
        per = new char[3];

        //연산자 우선순위 순열 구하기
        getPriority(0);

        return max;
    }

    private static void getPriority(int n) {
        if (n == 3) {
//            System.out.println(Arrays.toString(per));
            long result = Math.abs(solve(exp));
            if(result > max) max = result;
        }

        for (int i = 0; i < 3; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            per[n] = operator[i];
            getPriority(n + 1);
            visited[i] = false;
        }
    }

    private static Long solve(String exp) {
        //1
        boolean check = true;
        for (int i = 0; i < exp.length(); i++) {
            if(!Character.isDigit(exp.charAt(i))) {
                check = false;
                break; //아직 연산자가 남아있다면 2번 for문 돌러가자
            }
        }
        if(check) return Long.parseLong(exp); //연산자 없이 숫자만 있다면 숫자 값 리턴

        //2 - 연산자가 남아있다면 더 쪼개기
        for (int i = 2; i >= 0; i--) {
            char op = per[i];
            if(!exp.contains(String.valueOf(op))) continue; //문자열 내에 해당 연산식 없으면 건너뛰기
            for (int j = exp.length()-1; j >=0; j--) {
                if (exp.charAt(j) == op) {
                    String s1 = exp.substring(0, j);
                    String s2 = exp.substring(j + 1);

                    long n1 = solve(s1);
                    long n2 = solve(s2);
//                    System.out.println(n1+" "+op+" "+n2);
                    if (op == '*') return n1 * n2;
                    else if (op == '+') return n1 + n2;
                    else if (op == '-') return n1 - n2;
                }
            }
        }
        return 0L;
    }


    public static void main(String[] args){
        System.out.println(solution("100-200*300-500+20"));
        System.out.println(solution("50*6-3*2"));

    }
}
