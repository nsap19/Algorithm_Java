package etc.programmers_Lv2;

import java.util.ArrayList;

public class Programmers_Lv2_14 {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args){
        System.out.println(solution("1924", 2));
        System.out.println("94");
        System.out.println(solution("1231234",3));
        System.out.println("3234");
        System.out.println(solution("4177252841",4));
        System.out.println("775841");
    }

    public static String solution(String number, int k) {
        String answer = "";

        int n = number.length();
        int r = number.length() - k; //뽑는 수의 갯수
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n ; i++) {
            arr[i] = number.charAt(i) -'0';
        }

        int[] result = new int[r];
        combination(arr, result, visited, 0, n, r);

        int max = 0;
        for (int i : arrayList){
            if(i>max) max = i;
        }

        answer = String.valueOf(max);

        return answer;
    }

    private static void combination(int[] arr, int[] result, boolean[] visited, int start, int n, int r) { //조합(n 개의 숫자 중에서 r 개의 수를 순서 없이 뽑는 경우)
        if (r == 0) { //더 뽑아야 할 갯수가 없을 때 print
            print(result,r);
            return;
        }

        //start에서 모든 경우의 수를 다 뽑은 후 i++이 됌
        for (int i = start; i < n; i++) { //visit 검사를 위한 for문, start보다 작으면 뽑을 후보에서 제외
            if (visited[i] != true) {
                visited[i] = true;
                result[result.length - r] = arr[i];
                combination(arr, result, visited, i + 1, n, r - 1); //start보다 큰 수 에서 수를 뽑기 위해 i+1에서 범위 시작
                visited[i] = false;
            }
        }


    }

    private static void print(int[] result, int r) {
        String numString = "";
        for (int i = 0; i < result.length; i++) {
            numString += String.valueOf(result[i]);
        }
        int num = Integer.parseInt(numString);
        if(!arrayList.contains(num)) {
            arrayList.add(num);
//            System.out.println(num);
        }
    }
}
