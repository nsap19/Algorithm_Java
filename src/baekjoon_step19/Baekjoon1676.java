// N!에 등장하는 수 중 2 와 5가 있으면 끝자리가 0이 되고, 그 갯수는 5의 갯수만큼 나온다
// 대신 50과 같은 경우 5가 2번, 2가 1번 곱해져 있다. 그렇다면 50은 0이 두개여야하는데 2때문에 1번 곱해진 것이 된다
// 따라서 순수 5가 몇번 곱해졌는지 알기 위해 2로 먼저 나눠 준 후 5가 몇번 곱해졌는지 구한다

// 단순히 팩토리얼 값을 직접 구해서 0개 갯수를 구하려고 하면 n이 일정치 이상이 되면 long으로도 값을 받을 수 없기 때문에 불가능하다
package baekjoon_step19;

import java.io.*;

public class Baekjoon1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int input;

        for (int i = 1; i <= n; i++) {
            input = i;

            while (input % 2 == 0 || input % 5 == 0) {
                if (input % 2 == 0) input /= 2;
                if (input % 5 == 0) {
                    input /= 5;
                    count++;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.close();
    }
}
