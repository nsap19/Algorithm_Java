/* 이상한 문자 만들기

문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

제한 사항
문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
*/

package etc;

import java.io.*;

public class Programmers_Lv1_18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        bw.write(solution(s));
        bw.close();
    }

    public static String solution(String s) {
        String answer = "";
        String[] str = s.split("");
        int count = 0;

        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(" ")) {
                count = 0;
                continue;
            }

            if (count % 2 == 0) str[i] = str[i].toUpperCase();
            else str[i] = str[i].toLowerCase();

            count++;
        }

        for (int i = 0; i < str.length; i++) {
            answer += str[i];
        }
        return answer;
    }
}

