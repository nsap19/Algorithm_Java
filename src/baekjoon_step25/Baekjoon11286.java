package baekjoon_step25;

import java.io.*;
import java.util.PriorityQueue;

public class Baekjoon11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 == abs2) return o1 > o2 ? 1 : -1;
            return abs1 - abs2; //더 큰 절대값을 리턴
        });

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0 && pq.isEmpty()) bw.write("0\n");
            else if (num == 0) bw.write(pq.poll() + "\n");
            else pq.add(num);
        }

        bw.close();
    }
}
