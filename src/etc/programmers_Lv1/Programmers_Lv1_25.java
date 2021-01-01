package etc.programmers_Lv1;

import java.io.*;

public class Programmers_Lv1_25 {
    public static void main(String[] args) throws IOException {
       System.out.println(solution(45)); // 7
        System.out.println(solution(125)); //229
    }

    public static int solution(int n) {
        int answer = 0;
        String str = "";

        while(n>=1){
            int temp = n%3;
            n /=3;
            str +=temp; //반전된 3진수로 만듦
        }

        answer = Integer.parseInt(str,3);

        return answer;
    }
}
