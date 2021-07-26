package etc.programmers_Lv2;


import java.util.Arrays;

public class Programmers_Lv2_16 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
        System.out.println(Arrays.toString(solution(8, 1)));
        System.out.println(Arrays.toString(solution(24, 24)));
    }

    public static int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int i = 3; i <= total / 2; i++) { //가로 길이는 세로 길이보다 같거나 크기때문에 절반만 반복
            if (total % i == 0) {
                int col = total / i; //가로 길이
                int row = total / col; //세로 길이

                int temp = col * 2; //위 아래 테두리
                temp += row * 2 - 4;//세로 양쪽 테투리 (카펫의 모서리 겹치는 부분 빼줌)


                if (temp == brown) return new int[]{col, row};
            }
        }
        return null;
    }
}
