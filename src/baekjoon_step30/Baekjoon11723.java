package baekjoon_step30;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int bitset = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String keyword = st.nextToken();
            int x;

            switch (keyword) {
                case "add": //S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
                    x = Integer.parseInt(st.nextToken());
                    bitset |= (1 << (x - 1));
                    break;
                case "remove": //S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
                    x = Integer.parseInt(st.nextToken());
                    bitset &= ~(1 << (x - 1));
                    break;
                case "check": //S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
                    x = Integer.parseInt(st.nextToken());
                    sb.append((bitset & (1 << (x - 1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle": //S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
                    x = Integer.parseInt(st.nextToken());
                    bitset ^= 1 << (x - 1); //XOR(^) : 대응하는 두 비트가 서로 다르면 1을 반환.
                    break;
                case "all": //S를 {1, 2, ..., 20} 으로 바꾼다.
                    bitset |= (~0);
                    break;
                case "empty": //S를 공집합으로 바꾼다.
                    bitset &= 0;
                    break;
            }
        }

        bw.write(sb.toString());
        bw.close();
    }
}

