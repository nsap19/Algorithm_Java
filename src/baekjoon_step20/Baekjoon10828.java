package baekjoon_step20;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("push")) {
                int v = Integer.parseInt(st.nextToken());
                stack.push(v);
            } else if (str.equals("pop")) {
                if (stack.size() == 0)
                    System.out.println(-1);
                else
                    System.out.println(stack.pop());
            } else if (str.equals("size")) System.out.println(stack.size());
            else if (str.equals("empty")) {
                if (stack.empty() == true) System.out.println(1);
                else System.out.println(0);
            } else if (str.equals("top")) {
                if (stack.size() == 0)
                    System.out.println(-1);
                else
                    System.out.println(stack.peek());
            }
        }
    }
}
