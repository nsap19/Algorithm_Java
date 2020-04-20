//파스칼의 삼각형 이용
//5C2 = 4C1 + 4C2
//4C1 = 3C0 + 3C1, 4C2 = 3C1 + 3C2
//f[i][j] = (f[i-1][j-1] + f[i-1][j]) % 10,007
//j가 0일 경우 또는 i와 j가 같을경우에는 값이 1이된다.

package baekjoon_step19;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] tri = new int[n + 1][n + 1];

        for (int i = 0; i < tri.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    tri[i][j] = 1;
                } else tri[i][j] = (tri[i - 1][j - 1] + tri[i - 1][j]) % 10007;
            }
        }
        bw.write(String.valueOf(tri[n][k]));
        bw.close();
    }
}
