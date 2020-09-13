package etc;

import java.util.*;

public class Liner_2020_2 {
    static int[] answer;
    static int size;
    static Deque<Integer> deque;
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        int[] ball1 = {1, 2, 3, 4, 5, 6};
        int[] order1 = {6, 2, 5, 1, 4, 3};
        int[] result1 = {6, 5, 1, 2, 4, 3};
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(solution(ball1, order1)));
        int[] ball2 = {11, 2, 9, 13, 24};
        int[] order2 = {9, 2, 13, 24, 11};
        int[] result2 = {24, 13, 9, 2, 11};
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(solution(ball2, order2)));

    }


    public static int[] solution(int[] ball, int[] order) {
        answer = new int[ball.length];
        size = 0;
        deque = new ArrayDeque<>();
        list = new ArrayList<>();

        for (int i = 0; i < ball.length; i++) {
            deque.add(ball[i]);
        }

        for (int i = 0; i < order.length; i++) {
            if (order[i] == deque.peekLast()) {
                deque.pollLast();
                answer[size] = order[i];
                size++;

                listCheck();
            } else if (order[i] == deque.peekFirst()) {
                deque.pollFirst();
                answer[size] = order[i];
                size++;

                listCheck();

            } else {
                list.add(order[i]);
            }
        }
        return answer;
    }

    static void listCheck() {
        int lsize = list.size();
        for (int j = 0; j < lsize; j++) {
            if (list.contains(deque.peekLast())) {
                list.remove(Integer.valueOf(deque.peekLast()));
                answer[size] = deque.peekLast();
                deque.pollLast();
                size++;
            } else if (list.contains(deque.peekFirst())) {
                list.remove(Integer.valueOf(deque.peekFirst()));
                answer[size] = deque.peekFirst();
                deque.pollFirst();
                size++;
            }
        }
    }
}




