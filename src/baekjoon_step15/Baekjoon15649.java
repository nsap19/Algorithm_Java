/* visited - 중복해서 뽑지 않기 위해 체크하는 값
* DFS를 돌면서 visited에 체크되지 않은 값들을 result배열에 넣음
* depth 값은 output 에 들어간 숫자의 길이
* depth의 값이 m 만큼 되면  result에 들어있는 값을 출력하면 됩니다.
*/
package baekjoon_step15;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon15649 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //수의 범위(1~n)
        int m = Integer.parseInt(st.nextToken()); //뽑는 수의 갯수
        int[] arr = new int[n];
        int[] result = new int[m];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        permutation(arr, result, visited, 0, n, m);

        bw.close();

    }

    private static void permutation(int[] arr, int[] result, boolean[] visited, int depth, int n, int m) throws IOException { //순열(순서있게 배열)
        if (depth == m) { //depth가 뽑아야하는 수와 같아지면 출력
            print(result, m);
            return;
        }

        for (int i = 0; i < n; i++) { //visit 검사를 위한 for문
            if (visited[i] != true) {
                visited[i] = true;
                result[depth] = arr[i];
                permutation(arr, result, visited, depth + 1, n, m);
                visited[i] = false;
            }
        }


    }

    private static void print(int[] result, int m) throws IOException {
        for (int i = 0; i < m; i++) {
            bw.write(result[i] + " ");
        }
        bw.newLine();
    }
}
