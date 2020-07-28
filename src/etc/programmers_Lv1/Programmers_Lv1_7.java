/*가운데 글자 가져오기
*
* 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

재한사항
s는 길이가 1 이상, 100이하인 스트링입니다.
* */
package etc.programmers_Lv1;

import java.io.*;

public class Programmers_Lv1_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        bw.write(solution(s));
        bw.close();
    }

    public static String solution(String s) {
        String answer = "";
        String[] arr = s.split("");

        if (arr.length % 2 == 0) answer = arr[arr.length / 2 - 1] + arr[arr.length / 2];
        else answer = arr[arr.length / 2];
        return answer;
    }
}

