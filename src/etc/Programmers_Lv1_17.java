/* 수박수박수박수박수박수?

길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.

제한 조건
n은 길이 10,000이하인 자연수입니다.
*/
package etc;

import java.io.*;

public class Programmers_Lv1_17 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(solution(n));
        bw.close();
    }

    public static String solution(int n) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) answer += "수";
            else answer += "박";
        }
        return answer;

        //다른 사람의 풀이
//        return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);

    }
}

