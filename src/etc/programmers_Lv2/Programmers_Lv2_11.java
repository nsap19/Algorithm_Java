package etc.programmers_Lv2;

import java.io.*;
import java.util.PriorityQueue;

public class Programmers_Lv2_11 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));

    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        while (pq.peek() <= K) {
            if (pq.size() == 1) return -1;

            int result = pq.poll() + pq.poll() * 2;
            pq.add(result);
            answer++;
        }

        return answer;
    }
}
