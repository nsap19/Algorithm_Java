//문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
//        s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
//
//        제한 사항
//        str은 길이 1 이상인 문자열입니다.

//        입출력 예
//        s	        return
//        Zbcdefg	gfedcbZ
package etc.programmers_Lv1;

import java.io.*;
import java.util.Arrays;

public class Programmers_Lv1_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = "Zbcdefg";
        System.out.println("s : "+s);
        System.out.println("return : "+ Solution.solution(s));

    }


    static class Solution {
        public static String solution(String s) {
            String answer = "";
            int[] arr = new int[s.length()];

            for(int i=0; i < s.length(); i++){
                arr[i]=(int)s.charAt(i);
            }

            Arrays.sort(arr);

            for(int i=arr.length-1; i >= 0; i--){
                answer += (char)arr[i];
            }
            return answer;
        }
    }
}

