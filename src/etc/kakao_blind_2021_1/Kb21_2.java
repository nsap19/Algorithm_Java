package etc.kakao_blind_2021_1;

import java.io.*;
import java.util.*;

public class Kb21_2 {
    static ArrayList<String> comb;

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
        System.out.println("AC, ACDE, BCFG, CDE");

    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {
            comb = new ArrayList<>();
            for (int j = 0; j < orders.length; j++) {
                int n = orders[j].length();
                if (n >= course[i]) {
                    String[] arr = orders[j].split("");
                    Arrays.sort(arr);
                    combination(arr, new boolean[n], 0, n, course[i]); //코스갯수별 나올 수 있는 조합 구하기 => comb
                }
            }
            if(!comb.isEmpty()) comb = count(comb);//조합 중 가장 많이 주문된 조합 구함(중복 갯수 있을 수 있음)

            for (int j = 0; j < comb.size(); j++) {
                result.add(comb.get(j));
            }
        }

        answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        Arrays.sort(answer);
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
            combination(arr, visited, i + 1, n, r - 1);
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

    private static ArrayList<String> count(ArrayList<String> comb) {
        HashMap<String, Integer> comb_count = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        //조합별 메뉴와 해당 메뉴 주문 갯수 => comb_count
            for (int i = 0; i < comb.size(); i++) {
                if (comb_count.containsKey(comb.get(i))) {
                    comb_count.put(comb.get(i), comb_count.get(comb.get(i)) + 1);
                } else comb_count.put(comb.get(i), 1);
            }


        //주문 갯수 내림차순 정렬된 메뉴 => combList
        List<String> combList = new ArrayList<>(comb_count.keySet());
        Collections.sort(combList); //이름순 정렬
        Collections.sort(combList, ((o1, o2) -> comb_count.get(o2).compareTo(comb_count.get(o1)))); //주문수 별 정렬

        // 가장 많이 함께 주문된 메뉴 구성이 여러 개일 경우를 위함
        int max = comb_count.get(combList.get(0));
        for (String key : combList) {
            int x = comb_count.get(key);
//            System.out.println(key + " / " + x);
            if (x >= 2) {
                if (result.isEmpty() || max == x) result.add(key);
            }
        }
        return result;
    }
}
