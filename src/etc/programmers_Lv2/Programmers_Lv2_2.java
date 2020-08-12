package etc.programmers_Lv2;

import java.io.*;
import java.util.*;

public class Programmers_Lv2_2 {
    static class Joosik {
        int price;
        int time;

        public Joosik(int price, int time) {
            this.price = price;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] prices_s = br.readLine().split(", ");
        int[] prices = Arrays.stream(prices_s).mapToInt(Integer::parseInt).toArray();

        bw.write(Arrays.toString(solution(prices)));
        bw.close();
    }


    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Joosik> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.peek().price > prices[i]) {
                Joosik j = stack.pop();
                answer[j.time] = i - j.time;
            }
            stack.push(new Joosik(prices[i], i));
        }

        while (!stack.isEmpty()) {
            Joosik j = stack.pop();
            answer[j.time] = prices.length - j.time - 1;
        }
        return answer;
    }
}

