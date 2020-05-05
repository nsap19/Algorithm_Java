/* 첫번째 시도 - 출력문에 k번째 숫자를 추가해줄 때 마다 count를 다시 1로 초기화 해줌 => 시간초과
*  두번째 시도 - count를 숫자 추가때마다 1로 초기화 하는 대신 count는 계속 증가시키고 k의 배수인지만 확인해줌 */

package baekjoon_step21;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int count = 0;
        bw.write("<");
        while (!q.isEmpty()) {
            count++;
            if (count % k == 0) { //k의 배수일 때 출력문에 삽입
                if (q.size() > 1) { //맨 마지막 수를 제외하고는 수 뒤에 ", "삽입
                    bw.write(String.valueOf(q.poll()) + ", ");
                } else bw.write(String.valueOf(q.poll()) + ">"); //맨 마지막 수에는 닫는 괄호(>) 삽입
            } else { //k의 배수가 아닐때는 맨앞의 수를 다시 큐의 맨뒤에 삽입해준다.
                int v = q.poll();
                q.offer(v);
            }
        }
        bw.close();

    }
}
