package etc.programmers_Lv2;

import java.util.Arrays;

public class Programmers_Lv2_17 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(solution(new int[]{2, 5, 5, 5, 5}));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int len = citations.length;
        for (int i = len-1; i >=0 ; i--) {
            if(citations[i]==len-i) answer = citations[i];
            else if(citations[i]> len-i) answer = len-i;
        }
        return answer;
    }
}
