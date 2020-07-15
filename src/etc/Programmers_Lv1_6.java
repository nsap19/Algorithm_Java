package etc;

import java.io.*;

public class Programmers_Lv1_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());
        bw.write(solution(month,day));
        bw.close();
    }

    public static String solution(int a, int b) {
        String answer = "";
        int first = 5;
        String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = first - 1;

        for (int i = 0; i < a - 1; i++) {
            day += month[i];
        }

        day = (day + b) % 7;
        answer = week[day];

        return answer;
    }
}


