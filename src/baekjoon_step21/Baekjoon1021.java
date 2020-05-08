package baekjoon_step21;

import java.io.*;
import java.util.*;

public class Baekjoon1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Integer> nums = new ArrayDeque<>(); //1부터 n까지 숫자로 채워진 덱
        Deque<Integer> d = new ArrayDeque<>(); //뽑아야하는 수의 위치

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int ct = st2.countTokens();
        for (int i = 1; i <= n; i++) { //nums채우기
            nums.addLast(i);
        }
        for (int i = 0; i < ct; i++) { //d 채우기
            d.addLast(Integer.parseInt(st2.nextToken()));
        }

        int count = 0;
        while (!d.isEmpty()) { //뽑아야하는 값이 없을 때 까지 반복
            if (d.getFirst() == nums.getFirst()) { //순서대로 뽑아야하는 수와 nums의 맨 앞의 수가 같으면 값을 뽑음
                d.pollFirst();
                nums.pollFirst();
            } else {
                int howMove = getIndex(d, nums); //nums에서 뽑아야하는 수의 현 위치
                if (nums.size() - howMove >= nums.size() / 2) { //왼쪽으로 이동하는게 빠를 때
                    for (int i = 0; i < howMove - 1; i++) {
                        count++;
                        nums = moveLeft(nums);
                    }
                } else { //오른쪽으로 이동하는게 빠를 때
                    for (int i = 0; i < nums.size() - howMove + 1; i++) {
                        count++;
                        nums = moveRight(nums);
                    }
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.close();

    }

    private static Deque<Integer> moveRight(Deque<Integer> d) { //덱을 오른쪽으로 이동
        d.addFirst(d.pollLast());
        return d;
    }

    private static Deque<Integer> moveLeft(Deque<Integer> d) { //덱을 왼쪽으로 이동
        d.addLast(d.pollFirst());
        return d;
    }

    private static int getIndex(Deque<Integer> d, Deque<Integer> nums) { //찾고자 하는 수(d.getFirst())의 위치를 리턴
        int index = 0;
        Iterator<Integer> e = nums.iterator();
        while (e.hasNext()) {
            index++;
            int n = e.next();
            if (d.getFirst() == n) return index;
        }
        return index;
    }

    private static void print(Deque<Integer> d) { //디버깅을 위한 프린트 함수
        Iterator<Integer> e = d.iterator();
        while (e.hasNext()) {
            System.out.print(e.next() + " ");
        }
        System.out.println();
    }
}
