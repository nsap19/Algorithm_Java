/* 실패율

실패율은 다음과 같이 정의한다.
스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때,
실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.

제한사항
스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
stages의 길이는 1 이상 200,000 이하이다.
stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.

입출력 예
N	stages	                    result
5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
4	[4, 4, 4, 4, 4]	            [4,1,2,3]
*/
package etc.programmers_Lv1;

import java.io.*;
import java.util.*;


public class Programmers_Lv1_21 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] answers_s = br.readLine().split(", ");
        int[] stages = Arrays.stream(answers_s).mapToInt(Integer::parseInt).toArray();
        double[][] fail = new double[n][2]; //fail[i][0]은 단계번호, fail[i][1]은 실패율
        Queue<Integer> q = new LinkedList<>();
        int[] answer = new int[n];

        Arrays.sort(stages);
        for (int i = 0; i < stages.length; i++) {
            q.add(stages[i]);
        }

        for (int i = 0; i < n; i++) {
            int user = q.size();
            int step = i + 1;
            int failUser = 0;
            while (!q.isEmpty() && q.peek() == step) {
                q.poll();
                failUser++;
            }
            fail[i][0] = step;
            fail[i][1] = user != 0 ? (double) failUser / user : 0;
        }

        Arrays.sort(fail, (o1, o2) -> {
            if (o1[1] == o2[1]) return -1;
            else return Double.compare(o1[1], o2[1]);
        });

        //중간과정 출력
//        for (int i = 0; i < fail.length ; i++) {
//            System.out.println(fail[i][0] + " " + fail[i][1]);
//        }

        for (int i = 0; i < fail.length; i++) {
            answer[fail.length - i - 1] = (int) fail[i][0];
        }

        bw.write(Arrays.toString(answer));
        bw.close();
    }
}

