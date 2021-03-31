package etc.kakao_blind_2021_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Kb21_2 {
    static ArrayList<String> comb = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
        System.out.println("AC, ACDE, BCFG, CDE");

    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length ; j++) {
                int n = orders[j].length();
                if(n >= course[i]) {
                    combination(orders[j].split(""), new boolean[n], 0, n,course[i]);
                }
            }
        }

        for (int i = 0; i < comb.size() ; i++) {
            System.out.println(comb.get(i));
        }

        return answer;
    }

    private static void combination(String[] arr, boolean[] visited, int start, int n, int r) {
        //코스갯수(r)에 맞는 모든 조합을 만든다
        if (r == 0) {
            print(arr, visited);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr,visited,i+1, n,r-1);
            visited[i] = false;
        }

    }

    private static void print(String[] arr, boolean[] visited) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == true) {
                result += arr[i];
            }
        }
        comb.add(result);
    }
}
