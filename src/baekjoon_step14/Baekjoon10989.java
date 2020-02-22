/* counting sort */
/* 시간초과의 이유로 정석의 countring sort는 아니지만 갯수를 세서 하는 방식을 이용 */

package baekjoon_step14;

import java.io.*;

public class Baekjoon10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] count = new int[10001];

        for (int i = 0; i < n; i++) { //입력받은 수의 갯수 세기
            count[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                for (int j = 0; j < count[i]; j++) {
                    bw.write(i + "\n");
                }
            }
        }

//        bw.flush(); //flush()를 사용하면 시간초과가 뜬다고 함
        bw.close();

    }
}
