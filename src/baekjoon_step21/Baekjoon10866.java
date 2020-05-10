package baekjoon_step21;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> d = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {
                case "push_front": //정수 X를 덱의 앞에 넣는다.
                    int x = Integer.parseInt(st.nextToken());
                    d.addFirst(x);
                    break;
                case "push_back": //정수 X를 덱의 뒤에 넣는다.
                    x = Integer.parseInt(st.nextToken());
                    d.addLast(x);
                    break;
                case "pop_front": //덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    if (d.isEmpty()) bw.write("-1\n");
                    else bw.write(String.valueOf(d.pollFirst()) + "\n");
                    break;
                case "pop_back": //덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    if (d.isEmpty()) bw.write("-1\n");
                    else bw.write(String.valueOf(d.pollLast()) + "\n");
                    break;
                case "size": //덱에 들어있는 정수의 개수를 출력한다.
                    bw.write(String.valueOf(d.size()) + "\n");
                    break;
                case "empty": //덱이 비어있으면 1을, 아니면 0을 출력한다.
                    if (d.isEmpty()) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                case "front": //덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    if (d.isEmpty()) bw.write("-1\n");
                    else bw.write(String.valueOf(d.getFirst()) + "\n");
                    break;
                case "back": //덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    if (d.isEmpty()) bw.write("-1\n");
                    else bw.write(String.valueOf(d.getLast()) + "\n");
                    break;
            }
        }
        bw.close();
    }
}
