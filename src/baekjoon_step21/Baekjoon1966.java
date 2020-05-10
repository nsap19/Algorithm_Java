/* 중요도의 최댓값과 비교해서 큐에서 poll하거나 맨뒤로 offer하는 것은 어렵지 않았음
 * 대신 찾고자하는 인덱스 값의 위치가 계속해서 변해 그 위치를 찾는게 어려웠음
 * 그래서 처음 입력 받을때 큐에서 찾고자하는 인덱스의 값을 범위 밖 수인 101로 받음
 * 그렇게 되면 중요도의 최댓값을 비교하는게 큐의 맨앞 수가 아닌 arraylist의 0번째 값이 됨 */
package baekjoon_step21;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); //테스트케이스

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //총 문서의 갯수
            int m = Integer.parseInt(st.nextToken()); //궁금한 문서의 순서

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            Queue<Integer> q = new LinkedList<>(); //문서의 중요도
            ArrayList<Integer> arr = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st2.nextToken());
                if (j == m) q.offer(101);
                else q.offer(num);
                arr.add(num); //중요도의 가장 큰 수를 찾기 위한 배열
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
                    if (q.peek() == 101) bw.write(String.valueOf(count) + "\n"); //그 수가 찾고자 하는 번호의 수 일 때

                    q.poll();
                    arr.remove(0);
                }
            }
        }
        bw.close();
    }

    private static int getMax(ArrayList<Integer> arr) {
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (max <= arr.get(i)) max = arr.get(i);
        }
        return max;
    }
}
