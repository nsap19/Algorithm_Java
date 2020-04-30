package baekjoon_step20;

import java.io.*;
import java.util.Stack;

public class Baekjoon4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        loop1:
        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break;

            Stack<String> stack1 = new Stack<>();


            for (int i = 0; i < line.length(); i++) {
                char str = line.charAt(i);

                if (str == '(') stack1.push("(");
                if (str == ')') {
                    if (stack1.size() > 0 && stack1.peek() == "(") {
                        stack1.pop();
                    } else {
                        bw.write("no\n");
                        continue loop1;
                    }
                }
                if (str == '[') stack1.push("[");
                if (str == ']') {
                    if (stack1.size() > 0 && stack1.peek() == "[") {
                        stack1.pop();
                    } else {
                        bw.write("no\n");
                        continue loop1;
                    }
                }
            }

            if (stack1.size() == 0) {
                bw.write("yes\n");
            }
            else bw.write("no\n");

        }
        bw.close();
    }
}
