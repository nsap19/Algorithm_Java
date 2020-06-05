/* 자바의 PriortyQueue 라이브러리는 기본적으로 min힙으로 구성되어있다.
하지만 다음과 같은 방법으로 우선순위를 바꾸어서 쉽게 문제를 해결할수있다.
*/
package baekjoon_step25;

import java.io.*;
import java.util.*;

public class Baekjoon11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0 && pq.isEmpty()) bw.write(0 + "\n");
            else if (num == 0) bw.write(pq.poll() + "\n");
            else pq.add(num);
        }

        bw.close();
    }
}
