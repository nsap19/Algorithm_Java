package etc.programmers_Lv2;

import java.io.*;

public class Programmers_Lv2_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write(solution(n));
        bw.close();
    }

    public static String solution(int n) {
        String answer = "";

        while (n != 0) {
            int remain = n % 3;
            n /= 3;

            if (remain == 1) {
                answer = "1" + answer;
            } else if (remain == 2) {
                answer = "2" + answer;
            } else {
                answer = "4" + answer;
                n--;
            }
        }
        return answer;
    }
}

