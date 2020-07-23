/* 문자열 내 p와 y의 개수

* 대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.

예를 들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다.

제한사항
문자열 s의 길이 : 50 이하의 자연수
문자열 s는 알파벳으로만 이루어져 있습니다.
* */

package etc;

import java.io.*;

public class Programmers_Lv1_13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        bw.write(Boolean.toString(solution(s)));
        bw.close();
    }

    public static boolean solution(String s) {
        boolean answer = true;

        s = s.toLowerCase();

        int countP = 0;
        int countY = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') countP++;
            else if (s.charAt(i) == 'y') countY++;
        }

        if (countP != countY) answer = false;

        return answer;
    }
}

