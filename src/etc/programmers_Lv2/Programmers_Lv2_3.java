package etc.programmers_Lv2;

import java.io.*;
import java.util.*;


public class Programmers_Lv2_3 {
    static class Progress {
        int num;
        int day;

        public Progress(int num, int day) {
            this.num = num;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] progresses_s = br.readLine().split(", ");
        String[] speeds_s = br.readLine().split(", ");
        int[] progresses = Arrays.stream(progresses_s).mapToInt(Integer::parseInt).toArray();
        int[] speeds = Arrays.stream(speeds_s).mapToInt(Integer::parseInt).toArray();

        bw.write(Arrays.toString(solution(progresses, speeds)));
        bw.close();
    }


    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int len = progresses.length;
        Queue<Progress> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int pDay = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) pDay++;

            int count = 0;
            while (!q.isEmpty() && q.peek().day < pDay) {
                count++;
                q.poll();
            }
            if (count != 0) list.add(count);
            q.add(new Progress(i, pDay));
        }

        int count = 0;
        while (!q.isEmpty()) {
            Progress p = q.poll();
            count++;
        }
        if (count != 0) list.add(count);

        answer = new int[list.size()];
        int size = 0;
        for (int temp : list) {
            answer[size++] = temp;
        }
        return answer;
    }
}