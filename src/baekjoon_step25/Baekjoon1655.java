/* 중간값보다 큰 수들은 minHeap에 넣고
중간값이 maxHeap의 최대값이 되도록 만든다
따라서 들어오는 수마다 maxHeap의 최대값과 비교를 해서
maxHeap의 최대값보다 작다면 기존의 maxHeap의 최대값을 minHeap으로 보내주고
새로 들어오는 수가 maxHeap의 최대값이 되도록 한다

maxHeap = 0 ~ mid (중간값을 포함) (오름차순)
minHeap = mid+1 ~ 마지막 수 (내림차순)
* */
package baekjoon_step25;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Baekjoon1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (maxHeap.size() == minHeap.size()) maxHeap.add(num); //크기가 같은 경우 maxHeap에 삽입
            else minHeap.add(num); //크기가 다른 경우 minHeap에 삽입

            if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()) { // 입력한 값이 minHeap의 최솟값보다 크다면 둘을 swap
                    int temp = minHeap.poll();
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(temp);
                }
            }

            bw.write(maxHeap.peek() + "\n");
        }
        bw.close();


    }
}
