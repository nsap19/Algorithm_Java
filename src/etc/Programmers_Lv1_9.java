/* 나누어 떨어지는 숫자 배열
* array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

제한사항
arr은 자연수를 담은 배열입니다.
정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
divisor는 자연수입니다.
array는 길이 1 이상인 배열입니다.
* */
package etc;

import java.io.*;
import java.util.*;

public class Programmers_Lv1_9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] answers_s = br.readLine().split(",");
        int divisor = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(answers_s).mapToInt(Integer::parseInt).toArray();

        bw.write(Arrays.toString(solution(arr,divisor)));
        bw.close();
    }

    public static int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0)
                list.add(arr[i]);
        }

        int size = 0;
        if (list.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[list.size()];
            for (int temp : list) answer[size++] = temp;
            Arrays.sort(answer);
        }
        return answer;
    }
}
