package etc.programmers_Lv2;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Programmers_Lv2_26 {
//    static ArrayList<String> lang = new ArrayList<>(Arrays.asList("cpp", "java", "python"));
//    static ArrayList<String> job = new ArrayList<>(Arrays.asList("backend", "frontend"));
//    static ArrayList<String> career = new ArrayList<>(Arrays.asList("junior", "senior"));
//    static ArrayList<String> food = new ArrayList<>(Arrays.asList("chicken", "pizza"));

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"})));

    }

    private static int[] solution(String[] info, String[] query) {
        String[][] arr = new String[info.length][5];
        int[] result = new int[query.length];
        StringTokenizer st;

        for (int i = 0; i < info.length; i++) {
            st = new StringTokenizer(info[i], " ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = st.nextToken();
            }
        }

        for (int i = 0; i < query.length; i++) {
            String[] thisQuery = query[i].replaceAll("and ", "").split(" ");
            int count = 0;
            loop:
            for (int j = 0; j < arr.length; j++) {
                count++; //일단은 조건에 부합하는 사람이 있다고 치자
                for (int k = 0; k < 5; k++) {
                    if (thisQuery[k].equals("-")) continue; //조건 안따져도 됌
                    if (k == 4) {
                        if (Integer.parseInt(arr[j][k]) < Integer.parseInt(thisQuery[k])) {
                            count--;
                        }
                        break;
                    }
                    if (!arr[j][k].equals(thisQuery[k])) {
                        count--;
                        break;
                    }
                }
            }
            result[i] = count;


        }

        return result;
    }
}

