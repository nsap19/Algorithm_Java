//어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
// 예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다. z는 1만큼 밀면 a가 됩니다.
// 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
//
//        제한 조건
//        공백은 아무리 밀어도 공백입니다.
//        s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
//        s의 길이는 8000이하입니다.
//        n은 1 이상, 25이하인 자연수입니다.

//입출력 예
//        s |   n	|   result
//        AB    |   1	|   BC
//        z |   1	|   a
//        a B z |   4   |   e F d

/* 놓쳤던 반례
기존에는 알파벳에 n을 더한 값이 Z~a,z이상인 경우만 처리해줌
하지만 Z (90) + 25 = s (115)가 나와서 이부분에서 틀렸음

대문자는 대문자끼리, 소문자는 소문자끼리 순환해야하기때문에 초반에 start를 구해줘서 계산함
* */

package etc;

import java.io.*;

public class Programmers_Lv1_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String result = solution(s, n);
        bw.write(result);
        bw.close();
    }

    public static String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            int alpha = (int) s.charAt(i);
            int start = 0;

            if (alpha >= 'a' && alpha <= 'z') start = 'a';
            else if (alpha >= 'A' && alpha <= 'Z') start = 'A';

            if (alpha != ' ') alpha = start + (alpha + n - start) % 26;

            answer += (char) alpha;
        }
        return answer;
    }
}


