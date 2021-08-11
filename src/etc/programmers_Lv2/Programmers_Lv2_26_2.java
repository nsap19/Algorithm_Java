package etc.programmers_Lv2;

import java.util.*;

public class Programmers_Lv2_26_2 {
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"})));

    }

    private static int[] solution(String[] info, String[] query) {
        int[] result = new int[query.length];
        //개발자 조건 조합 만들기
        for (int i = 0; i < info.length; i++) {
            String[] exp = info[i].split(" ");
            //들어온 조건, - 들의 조합으로 String을 만들어 map의 key로 사용
            makeKey(exp);
        }

        //map의 value(arraylist) 정렬
        ArrayList<String> keyList = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            if (keyList.contains(entry.getKey())) continue;
            else {
                keyList.add(entry.getKey());
                Collections.sort(entry.getValue());
            }
        }

        //query 배열 탐색
        for (int i = 0; i < query.length; i++) {
            String[] exp = query[i].split(" ");
            String key = exp[0] + exp[2] + exp[4] + exp[6];

            if (!map.containsKey(key)) {
                result[i] = 0;
                continue;
            }

            ArrayList<Integer> scores = map.get(key);
            if (exp[7].equals("-")) {
                result[i] = scores.size();
            } else {
                int score = Integer.parseInt(exp[7]);
                result[i] = searchBinary(scores, score);
            }
        }

        return result;
    }

    private static void makeKey(String[] exp) {
        String[] lang = {exp[0], "-"};
        String[] job = {exp[1], "-"};
        String[] career = {exp[2], "-"};
        String[] food = {exp[3], "-"};
        int score = Integer.parseInt(exp[4]);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        String key = lang[i] + job[j] + career[k] + food[l];

                        if (!map.containsKey(key)) {
                            ArrayList<Integer> scores = new ArrayList<>();
                            scores.add(score);
                            map.put(key, scores);
                        } else {
                            ArrayList<Integer> scores = map.get(key);
                            scores.add(score);
                            map.put(key, scores);
                        }
                    }
                }
            }
        }
    }

    private static int searchBinary(ArrayList<Integer> scores, int score) {
        int start = 0;
        int mid = 0;
        int end = scores.size();

        while (start < end) {
            mid = (start + end) / 2;
            if (scores.get(mid) < score) start = mid + 1;
            else end = mid;
        }

        return scores.size() - start;
    }
}
