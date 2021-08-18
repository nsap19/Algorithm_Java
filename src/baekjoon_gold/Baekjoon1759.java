package baekjoon_gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1759 {
    static StringBuilder sb = new StringBuilder();
    static String[] result, alpha;
    static int L, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다.
        // 또한 정렬된 문자열을 선호하는 조교들의 성향으로 미루어 보아 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측된다.
        // 즉, abc는 가능성이 있는 암호이지만 bac는 그렇지 않다.
        L = Integer.parseInt(st.nextToken()); //암호는 서로 다른 L개의 알파벳 소문자들로 구성
        C = Integer.parseInt(st.nextToken()); //C개의 문자들이 공백으로 구분되어 주어진다.
        result = new String[L];
        alpha = new String[C];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken();
        }

        Arrays.sort(alpha);

        combi(0, 0);

        System.out.println(sb);
    }

    private static void combi(int cnt, int start) {
        if (cnt == L) {
            int x = 0; //모음 갯수
            int y = 0; //자음 갯수
            for (int i = 0; i < L; i++) {
                String temp = result[i];
                if (temp.equals("a") || temp.equals("e") || temp.equals("i") || temp.equals("o") || temp.equals("u"))
                    x++;
                else y++;
            }

            if (x >= 1 && y >= 2) {
                for (String str : result)
                    sb.append(str);
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            result[cnt] = alpha[i];
            combi(cnt + 1, i + 1);
        }
    }
}
