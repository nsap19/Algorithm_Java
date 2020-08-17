package etc.programmers_Lv2;

import java.io.*;
import java.util.*;

public class Programmers_Lv2_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] priorities_s = br.readLine().split(", ");
        int location = Integer.parseInt(br.readLine());
        int[] priorities = Arrays.stream(priorities_s).mapToInt(Integer::parseInt).toArray();

        bw.write(String.valueOf(solution1(priorities, location)));
//        bw.write(String.valueOf(solution2(priorities, location)));
        bw.close();
    }

    public static int solution1(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>(); //문서의 중요도
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            if (i == location) q.offer(101);
            else q.offer(priorities[i]);
            arr.add(priorities[i]); //중요도의 가장 큰 수를 찾기 위한 배열
        }

        int count = 0;
        while (!q.isEmpty()) {
            int max = getMax(arr);
//                System.out.println(max);
            if (arr.get(0) < max) { //큐의 첫 요소의 중요도가 가장 크지 않다면 맨뒤로 삽입
                q.offer(q.poll());
                arr.add(arr.get(0));
                arr.remove(0);
            } else { //큐의 첫 요소의 중요도가 가장 큰 수일 때
                count++;
                if (q.peek() == 101)
                    answer = count;
                //그 수가 찾고자 하는 번호의 수 일 때

                q.poll();
                arr.remove(0);
            }
        }
        return answer;
    }

    private static int getMax(ArrayList<Integer> arr) {
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (max <= arr.get(i)) max = arr.get(i);
        }
        return max;
    }

    //다른 사람의 풀이
    public static int solution2(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for (int i : priorities) {
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length - 1;


        while (!que.isEmpty()) {
            Integer i = que.poll();
            if (i == priorities[size - answer]) {
                answer++;
                l--;
                if (l < 0) //l < 0 인 경우는 찾고자 하는 location의 프린터 순서가 되었을 때
                    break;
            } else {
                que.add(i);
                l--;
                if (l < 0) //찾고자 하는 location의 프린터 순서가 오지 않았는데 answer를 구하지 못하였으므로 que의 크기만큼 다시 더해줌
                    l = que.size() - 1;
            }
        }

        return answer;
    }
}

