package etc.programmers_Lv1;


public class Programmers_Lv1_23 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println("LRLLLRLLRRL");
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println("LRLLRRLLLRR");
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
        System.out.println("LLRLLRLLRL");


    }

    public static String solution(int[] numbers, String hand) {
        String result = "";
        int[][] numberArr = new int[][]{{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}}; //숫자별 눌러야하는 위치좌표
        int left_x = 3;
        int left_y = 0;
        int right_x = 3;
        int right_y = 2;

        for (int num : numbers) {
            int nextNum_x = numberArr[num][0];
            int nextNum_y = numberArr[num][1];

            if (num == 1 || num == 4 || num == 7) {
                left_x = nextNum_x;
                left_y = nextNum_y;
                result += "L";
            } else if (num == 3 || num == 6 || num == 9) {
                right_x = nextNum_x;
                right_y = nextNum_y;
                result += "R";
            } else {
                int left_length = Math.abs(left_x - nextNum_x) + Math.abs(left_y - nextNum_y);
                int right_length = Math.abs(right_x - nextNum_x) + Math.abs(right_y - nextNum_y);

                if (left_length < right_length || (left_length == right_length && hand.equals("left"))) {
                    left_x = nextNum_x;
                    left_y = nextNum_y;
                    result += "L";
                } else if (left_length > right_length || (left_length == right_length && hand.equals("right"))) {
                    right_x = nextNum_x;
                    right_y = nextNum_y;
                    result += "R";
                }
            }

        }

        return result;
    }
}
