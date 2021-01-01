package etc.programmers_Lv1;

import java.util.*;
import java.io.*;

public class Programmers_Lv1_24 {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1})));
    }

    public static int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = {};

        int temp=0;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length ; j++) {
                temp = numbers[i]+numbers[j];
                if(!list.contains(temp)) list.add(numbers[i] + numbers[j]);
            }
        }

        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);

       return answer;
    }
}

