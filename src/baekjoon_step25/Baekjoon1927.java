package baekjoon_step25;

import java.io.*;
import java.util.PriorityQueue;

public class Baekjoon1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0 && pq.isEmpty()) bw.write(0 + "\n");
            else if (num == 0) bw.write(pq.poll() + "\n");
            else pq.add(num);
        }

        bw.close();
    }
}
