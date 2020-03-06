package baekjoon_step15;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon14888 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[] nums;
    public static int[] operators;
    public static ArrayList<Integer> results = new ArrayList<>();
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        nums = new int[n];
        operators = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operators.length; i++) { //연산자 갯수 입력받기 (+ - * /)
            operators[i] = Integer.parseInt(st.nextToken());
        }

        result = nums[0];
        backtracking(0, result);

        Collections.sort(results);
        print(results);
    }

    public static void backtracking(int level, int result) {
        if (level == nums.length - 1) addResult(result);


        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                int temp = result;
                result = doOperate(result, i, nums[level + 1]);
                backtracking(level + 1, result);
                operators[i]++;
//                result = nums[0]; //이게 문제인듯 하다
                result = temp;
            }
        }


    }

    public static int doOperate(int result, int op, int num) {
        if (op == 0) result += num;
        else if (op == 1) result -= num;
        else if (op == 2) result *= num;
        else result /= num;

        return result;
    }

    public static void addResult(int result) {
        results.add(result);
    }

    public static void print(List<Integer> results) throws IOException {
        bw.write(String.valueOf(results.get(results.size() - 1)));
        bw.newLine();
        bw.write(String.valueOf(results.get(0)));

        bw.close();
    }

}
