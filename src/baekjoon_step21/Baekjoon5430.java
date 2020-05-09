package baekjoon_step21;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> d = new ArrayDeque<>();
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str.substring(1, str.length() - 1), ",");


            for (int j = 0; j < n; j++) { //입력 받은 수 덱에 삽입
                d.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean forward = true;
            boolean check = true;

            //수행할 함수 반복문
            for (int j = 0; j < p.length(); j++) {
                char s = p.charAt(j);

                if (s == 'R') {
                    if (forward) forward = false;
                    else forward = true;
                } else if (s == 'D') {
                    if (d.size() != 0) {
                        if (forward) d.pollFirst();
                        else d.pollLast();
                    } else check = false;

                    n--;
                }
            }

            if (check == false) bw.write("error\n");
            else if (n == 0) {
                bw.write("[]");
            } else {
                bw.write("[");
                if (forward) {
                    for (int j = 0; j < n - 1; j++) {
                        bw.write(d.pollFirst() + ",");
                    }
                    bw.write(String.valueOf(d.pollFirst()));
                } else {
                    for (int j = n - 1; j > 0; j--) {
                        bw.write(d.pollLast() + ",");
                    }
                    bw.write(String.valueOf(d.pollLast()));
                }
                bw.write("]\n");
            }
        }

        bw.close();

    }
}

