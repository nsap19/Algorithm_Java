package etc;

import java.io.*;

public class Programmers_2020_summercoding_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        int result = solution(input);
        bw.write(String.valueOf(result));
        bw.close();

        //입력 1987 - 출력 2013
        //입력 2015 - 출력 2016
    }

    public static int solution(int p) {
        int answer = 0;
        boolean same = false;

        while (!same) {
            p++;
            String[] str = String.valueOf(p).split("");
            if (!str[0].equals(str[1]) && !str[0].equals(str[2]) && !str[0].equals(str[3])) {
                if (!str[1].equals(str[2]) && !str[1].equals(str[3])) {
                    if (!str[2].equals(str[3]))
                        same = true;
                }
            }

        }
        answer = p;
        return answer;
    }
}
