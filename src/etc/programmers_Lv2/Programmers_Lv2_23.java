package etc.programmers_Lv2;


public class Programmers_Lv2_23 {
    public static void main(String[] args) {
        System.out.println(solution(8, 1, 6));
        System.out.println(solution(8, 4, 8));
        System.out.println(solution(8, 3, 4)); //내가 멍청하게 생각 못햇던 부분,,,ㅜ
    }

    private static int solution(int n, int a, int b) {
        //a < b라는 보장은 없음
        int a2 = Math.min(a, b);
        int b2 = Math.max(a, b);
        int count = 1;

        while (true) {
            if (b2 % 2 == 0 && b2 - a2 == 1) break;
            count++;
            a2 = ++a2 / 2;
            b2 = ++b2 / 2;
        }
        return count;
    }

}
