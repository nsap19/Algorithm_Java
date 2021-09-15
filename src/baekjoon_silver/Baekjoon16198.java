package baekjoon_silver;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon16198 {
    static int N, max = 0;
    static int[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); //구슬의 갯수
        list = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        solve(N, 0);

        System.out.println(max);

    }

    private static void solve(int rest, int sum) { //rest는 남은 구슬
        if (rest == 2) {
            if (max < sum) max = sum;
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            if (visited[i]) continue;
            int right = i, left = i;
            for (int j = i - 1; j >= 0; j--) {
                if (!visited[j]) {
                    left = j;
                    break;
                }
            }
            for (int j = i + 1; j < N; j++) {
                if (!visited[j]) {
                    right = j;
                    break;
                }
            }

            visited[i] = true;
            solve(rest - 1, sum + list[right] * list[left]);
            visited[i] = false;
        }


    }
}
