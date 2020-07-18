package etc;

import java.io.*;
import java.util.*;


public class Programmers_Lv1_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] answers_s = br.readLine().split(",");
        int[] arr = Arrays.stream(answers_s).mapToInt(Integer::parseInt).toArray();

        bw.write(Arrays.toString(solution(arr)));
        bw.close();
    }


    public static int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();

        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                list.add(arr[i]);
            }
        }

        answer = new int[list.size()];
        int size = 0;
        for (int temp : list) answer[size++] = temp;

        return answer;
    }
}
