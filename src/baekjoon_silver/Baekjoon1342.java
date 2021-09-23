package baekjoon_silver;

import java.io.*;

public class Baekjoon1342 {
    static int len, arr[], cnt = 0;
    static char[] result;
    static boolean[] visited;
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        len = str.length();
        arr = new int[26];
        result = new char[len];
        visited = new boolean[len];

        for (int i = 0; i < len; i++) {
            arr[str.charAt(i) - 'a']++;
        }

        perm(0);

        //중복되는 알파벳을 팩토리얼로 나눠주어 생성된 문자열의 중복을 없앨 수 있음
        //기존에는 set을 사용해서 풀려고 했으나 메모리 초과가 났다. 그래서 이부분만 검색을 통해 해결
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 1)
                cnt /= factorial(arr[i]);
        }

        System.out.println(cnt);
    }

    private static void perm(int depth) { // 순열로 만들 수 있는 모든 조합의 문자열을 생성
        if (depth == len) {
            if (check())
                cnt++;
            return;
        }

        for (int i = 0; i < len; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            result[depth] = str.charAt(i);
            perm(depth + 1);
            visited[i] = false;

        }
    }

    private static boolean check() { // 행운의 문자열인지 체크
        for (int i = 1; i < result.length; i++) {
            if (result[i - 1] == result[i])
                return false;
        }
        return true;
    }

    private static int factorial(int N) {
        if (N == 1)
            return 1;
        return N * factorial(N - 1);
    }
}
