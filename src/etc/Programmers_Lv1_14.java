/* 문자열 다루기 기본

문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.

제한 사항
s는 길이 1 이상, 길이 8 이하인 문자열입니다.
* */

package etc;

import java.io.*;

public class Programmers_Lv1_14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        bw.write(Boolean.toString(solution(s)));
        bw.close();
    }

    public static boolean solution(String s) {
        boolean answer = true;

        if (!s.matches(".*[a-zA-Z].*") && s.length() == 4) answer = true;
        else if (!s.matches(".*[a-zA-Z].*") && s.length() == 6) answer = true;
        else answer = false;


        return answer;
    }
}

