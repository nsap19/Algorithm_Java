package baekjoon_step21;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        for (int i = 0; i < n; i++) {
            if (q.size() > 1) {
                q.poll();
                int v = q.peek();
                q.poll();
                q.offer(v);
            } else if (q.size() == 1) bw.write(String.valueOf(q.peek()));
        }

        bw.close();
    }
}
