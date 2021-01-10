package etc.programmers_Lv2;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Programmers_Lv2_10 {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.out.println(solution("011"));

    }

    public static int solution(String numbers) throws IOException {
        int answer = 0;

        int n = numbers.length(); //뽑는 수의 갯수
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = numbers.charAt(i) - '0';
        }

        for (int i = 1; i <= n; i++) {
            int[] result = new int[i];
            permutation(arr, result, visited, 0, n, i);
        }

        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            int num = it.next();
            int check = 0; //약수 쌍의 갯수

            for (int j = 1; j < num; j++) {
                if (num % j == 0) check++; // 소수는 자신보다 작은 두 개의 자연수를 곱하여 만들 수 없는 1보다 큰 자연수
            }
            if (num > 1 && check == 1) {
                answer++;
            }
        }

        return answer;
    }

    private static void permutation(int[] arr, int[] result, boolean[] visited, int depth, int n, int m) throws IOException { //순열(순서있게 배열)
        if (depth == m) { //depth가 뽑아야하는 수와 같아지면 출력
            print(result, m);
            return;
        }

        for (int i = 0; i < n; i++) { //visit 검사를 위한 for문
            if (visited[i] != true) {
                visited[i] = true;
                result[depth] = arr[i];
                permutation(arr, result, visited, depth + 1, n, m);
                visited[i] = false;
            }
        }
    }

    private static void print(int[] result, int m) {
        String numString = "";
        for (int i = 0; i < m; i++) {
            numString += String.valueOf(result[i]);
        }
        int num = Integer.parseInt(numString);
        if(!arrayList.contains(num)) arrayList.add(num);
    }
}
