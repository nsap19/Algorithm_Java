package baekjoon_step20;

import java.io.*;
import java.util.Stack;

public class Baekjoon9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            Stack<String> stack1 = new Stack<>();
            Stack<String> stack2 = new Stack<>();
            String[] arr = br.readLine().split("");
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals("(")) {
                    stack1.push("(");
                } else if (arr[j].equals(")")) {
                    stack2.push(")");
                    if (stack1.size() > 0) {
                        stack1.pop();
                        stack2.pop();
                    }
                }
            }

            if (stack1.size() == 0 && stack2.size() == 0) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.close();
    }
}
