/* 서울에서 김서방 찾기

String형 배열 seoul의 element중 Kim의 위치 x를 찾아, 김서방은 x에 있다는 String을 반환하는 함수, solution을 완성하세요. seoul에 Kim은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.

제한 사항
seoul은 길이 1 이상, 1000 이하인 배열입니다.
seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
Kim은 반드시 seoul 안에 포함되어 있습니다.
* */

package etc;

import java.io.*;
//import java.util.Arrays;

public class Programmers_Lv1_15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] seoul = br.readLine().split(",");
        bw.write(solution(seoul));
        bw.close();
    }

    public static String solution(String[] seoul) {
        String answer = "김서방은 ";
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim"))
                answer += i + "에 있다";
        }
        return answer;


        // 다른 사람의 풀이
//        int x = Arrays.asList(seoul).indexOf("Kim");
//
//        return "김서방은 "+ x + "에 있다";
    }
}

