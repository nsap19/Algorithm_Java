package etc;

import java.io.*;
import java.util.Stack;

public class CodingTest3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String answer = "";
        String[] banks = br.readLine().split(" ");

        for (int i = 0; i < banks.length; i++) { //끝지점
            Stack<String> bank = new Stack<>();

            if (i < 5) {
                for (int j = 0; j <= i; j++) { //시작 지점
                    bank.push(banks[j]);
                    System.out.println(j+" ~ "+i);
                }
            }
            else {
                for (int j = i - 5; j < i+1; j++) { //시작 지점
//                System.out.println(banks[j]+" "+bank.search(banks[j]));
                    bank.push(banks[j]);
                    System.out.println(j+" ~ "+i);
                }
            }

            for (int k = 0; k < bank.size(); k++) {
                if (!answer.contains(bank.peek())) answer += bank.pop()+" ";
            }
            System.out.println(answer);
            answer = "";
        }
    }
}
