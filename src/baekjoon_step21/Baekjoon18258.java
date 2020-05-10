package baekjoon_step21;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        int last = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str) {
                case "push":
                    int v = Integer.parseInt(st.nextToken());
                    q.offer(v);
                    last = v;
                    break;
                case "pop":
                    if (q.size() == 0) bw.write("-1\n");
                    else bw.write(String.valueOf(q.poll()) + "\n");
                    break;
                case "size":
                    bw.write(String.valueOf(q.size()) + "\n");
                    break;
                case "empty":
                    if (q.isEmpty() == true) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                case "front":
                    if (q.size() == 0) bw.write("-1\n");
                    else bw.write(String.valueOf(q.peek()) + "\n");
                    break;
                case "back":
                    if (q.size() == 0) bw.write("-1\n");
                    else bw.write(String.valueOf(last) + "\n");
                    break;
            }
        }
        bw.close();
    }
}
