/* 첫번째 방식 - R이 입력되면 실제로 덱을 반전시키는 덱을 하나 생성 => 시간초과 (질문검색에서 찾아보니 뒤집으라고 진짜 뒤집으면 안된다고,, 시간초과 무조건 난다고 했다)
* 두번째 방식 - 그래서 R이 입력되면 뒤에서부터 읽으면 되기 때문에 R이 들어올때마다 forward변수를 T/F로 바꿔줘 그 값에 따라 pollFirst, pollLast로 값을 읽고 D명령어를 실행했다.
* 세번째 방식 - 모든 반례나 예시가 다 맞게 나오는데 계속해서 틀렸습니다가 떠서 검색을 해봤다. 검색해보니 나처럼 bw.flush를 통해 결과값들을 한번에 출력하지 않고, 각 테스트케이스마다 결과값 한줄을 출력해서
  혹시나해서 출력방식만 변경하였더니 맞았습니다가 나왔다.
* */
package baekjoon_step21;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> d = new ArrayDeque<>();
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str.substring(1, str.length() - 1), ",");


            for (int j = 0; j < n; j++) { //입력 받은 수 덱에 삽입
                d.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean forward = true;
            boolean check = true;

            //수행할 함수 반복문
            for (int j = 0; j < p.length(); j++) {
                char s = p.charAt(j);

                if (s == 'R') {
                    if (forward) forward = false;
                    else forward = true;
                } else if (s == 'D') {
                    if (d.size() != 0) {
                        if (forward) d.pollFirst();
                        else d.pollLast();
                    } else check = false;

                    n--;
                }
            }

//            if (check == false) bw.write("error\n");
//            else if (n == 0) {
//                bw.write("[]");
//            } else {
//                bw.write("[");
//                if (forward) {
//                    for (int j = 0; j < n - 1; j++) {
//                        bw.write(d.pollFirst() + ",");
//                    }
//                    bw.write(String.valueOf(d.pollFirst()));
//                } else {
//                    for (int j = n - 1; j > 0; j--) {
//                        bw.write(d.pollLast() + ",");
//                    }
//                    bw.write(String.valueOf(d.pollLast()));
//                }
//                bw.write("]\n");

            if (check == false) System.out.print("error\n");
            else if (n == 0) {
                System.out.println("[]");
            } else {
                System.out.print("[");
                if (forward) {
                    for (int j = 0; j < n - 1; j++) {
                        System.out.print(d.pollFirst() + ",");

                    }
                    System.out.print(d.pollFirst());
                } else {
                    for (int j = n - 1; j > 0; j--) {
                        System.out.print(d.pollLast() + ",");
                    }
                    System.out.print(d.pollLast());
                }
                System.out.println("]");
            }
        }

//        bw.close();

    }
}

