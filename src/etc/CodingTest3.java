package etc;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class CodingTest3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] banks = br.readLine().split(" ");


        for (int i = 0; i < banks.length; i++) {
            Stack<String> stack = new Stack<>();

            for (int j = 0; j < i + 1; j++) {
                String bankName = banks[j];
                stack.push(bankName);
            }
//            System.out.println(stack.toString());

            Set<String> bankList = new LinkedHashSet<>();
            while (!stack.isEmpty()) {
                if (bankList.size() == 5) {
                    break;
                }
                bankList.add(stack.pop());
            }

            bankList.forEach(v -> {
                System.out.print(v+" ");
            });
            System.out.println();

        }
    }
}
