package baekjoon_step20;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("push")) {
                int v = Integer.parseInt(st.nextToken());
                stack.push(v);
            } else if (str.equals("pop")) { //스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력
                if (stack.size() == 0)
                    bw.write("-1\n");
                else
                    bw.write(String.valueOf(stack.pop())+"\n");
            } else if (str.equals("size")) bw.write(String.valueOf(stack.size())+"\n");
            else if (str.equals("empty")) {
                if (stack.empty() == true) bw.write("1\n");
                else bw.write("0\n");
            } else if (str.equals("top")) {
                if (stack.size() == 0)
                    bw.write("-1\n");
                else
                    bw.write(String.valueOf(stack.peek())+"\n"); //스택의 가장 위에 있는 정수를 출력
            }

            bw.flush();
        }
    }
}
