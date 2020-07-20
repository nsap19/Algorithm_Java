package etc;

import java.io.*;
import java.util.*;


public class Programmers_Lv1_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] lost_s = br.readLine().split(",");
        String[] reserve_s = br.readLine().split(",");
        int[] lost = Arrays.stream(lost_s).mapToInt(Integer::parseInt).toArray();
        int[] reserve = Arrays.stream(reserve_s).mapToInt(Integer::parseInt).toArray();

        bw.write(String.valueOf(solution(n,lost,reserve)));
        bw.close();

    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n + 1];
        student[0] = 0;

        for (int i = 1; i < student.length; i++) student[i] = 1; //1벌만 갖고있는 학생들을 설정하기 위함

        for (int j = 0; j < lost.length; j++) student[lost[j]] = 0; //도난당한 학생들 설정

        for (int i = 0; i < reserve.length; i++) student[reserve[i]]++; //여벌이 있지만 도난당해 1벌만 갖고있는 학생들을 위해 2가 아닌 ++로 설정


        for (int i = 0; i < lost.length; i++) {
            if (student[lost[i]] == 0) {
                if (student[lost[i] - 1] == 2 && lost[i] - 1 >= 1) {
                    student[lost[i] - 1]--;
                    student[lost[i]] = 1;
                } else if (lost[i] + 1 <= n && student[lost[i] + 1] == 2) { //두 조건문의 순서가 중요
                    student[lost[i] + 1]--;
                    student[lost[i]] = 1;
                }
            }
        }

        for (int i = 1; i < student.length; i++) {
            if (student[i] != 0)
                answer++;
        }


//        System.out.println(Arrays.toString(student));
        return answer;
    }
}

