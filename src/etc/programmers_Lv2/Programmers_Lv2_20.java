package etc.programmers_Lv2;

import java.util.Arrays;
import java.util.List;

public class Programmers_Lv2_20 {
    static List<Character> characters = Arrays.asList(new Character[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'});
    static boolean[] visited = new boolean[8];
    static int[] arr;
    static int count;
    static String[] data2;

    public static void main(String[] args) {

        System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"})); //3648
//        System.out.println(solution(2, new String[]{"M~C<2", "C~M>1"}));//0

    }

    private static int solution(int n, String[] data) {
        count = 0;
        data2 = data;
        arr = new int[8];

        permutation(0);

        return count;
    }

    private static void permutation(int r) {
        if (r == 8) {
            if (check()) {
//                System.out.println(Arrays.toString(arr));
                count++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (visited[i] == true) continue;

            visited[i] = true;
            arr[r] = i;


            permutation(r + 1);

            visited[i] = false;
        }


    }

    private static boolean check() {

        for (String str : data2) {
            int c1 = characters.indexOf(str.charAt(0));
            int c2 = characters.indexOf(str.charAt(2));
            char condition = str.charAt(3); //=,<,>
            int interval = str.charAt(4) - '0' + 1;
            int a = 0, b = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == c1) a = i;
                else if (arr[i] == c2) b = i;
            }

//        System.out.println(Arrays.toString(arr));
//        System.out.println(a+" "+b);

            if (condition == '=') {
                if (Math.abs(a - b) != interval) return false;
            } else if (condition == '>') {
                if (Math.abs(a - b) <= interval) return false;
            } else if (condition == '<') {
                if (Math.abs(a - b) >= interval) return false;
            }
        }

        return true;
    }

}



