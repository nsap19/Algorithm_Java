package baekjoon_step20;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (!br.readLine().equals(".")) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<String> stack1 = new Stack<>();
            Stack<String> stack2 = new Stack<>();


            for (int i = 0; i < st.countTokens(); i++) {
                String str = st.nextToken();

                if (str.contains("(")) stack1.push("(");
                if (str.contains(")")) {
                    if (stack1.size() > 0) {
                        stack1.pop();
                    } else {
                        bw.write("no");
                        break;
                    }
                }
                if (str.contains("[")) stack2.push("[");
                if (str.contains("]")) {
                    if (stack1.size() > 0) {
                        stack1.pop();
                    } else {
                        bw.write("no");
                        break;
                    }
                }
            }

            if (stack1.size() == 0 && stack2.size() == 0) {
                bw.write("yes");
            } else bw.write("no");
        }
        bw.close();
    }
}
