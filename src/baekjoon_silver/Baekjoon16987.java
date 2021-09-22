package baekjoon_silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon16987 {
    static int N, max;
    static int eggs[][], status[];//status는 내구도

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //가장 왼쪽의 계란을 든다.
        //손에 들고 있는 계란으로 깨지지 않은 다른 계란 중에서 하나를 친다. 단, 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다. 이후 손에 든 계란을 원래 자리에 내려놓고 3번 과정을 진행한다.
        //가장 최근에 든 계란의 한 칸 오른쪽 계란을 손에 들고 2번 과정을 다시 진행한다. 단, 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란을 치는 과정을 종료한다.

        //첫째 줄에 계란의 수를 나타내는 N(1 ≤ N ≤ 8)가 주어진다.
        // 그 다음 N개의 줄에는 계란의 내구도와 무게에 대한 정보가 주어진다.
        // i+1번째 줄에는 왼쪽에서 i번째에 위치한 계란의 내구도 Si(1 ≤ Si ≤ 300)와 무게 Wi(1 ≤ Wi ≤ 300)가 한 칸의 빈칸을 사이에 두고 주어진다.

        N = Integer.parseInt(br.readLine());
        eggs = new int[N][2];
        status = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            eggs[i][0] = Integer.parseInt(st.nextToken()); //내구도
            eggs[i][1] = Integer.parseInt(st.nextToken()); //무게

            status[i] = eggs[i][0];
        }

        hitEgg(0);
        System.out.println(max);
    }


    private static void hitEgg(int start) {
        if (start == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (status[i] <= 0) cnt++;
            }
            max = Math.max(max, cnt);
            return;
        }

        if (status[start] <= 0) hitEgg(start + 1); //손에 든 계란이 깨졌으면 넘어간다.
        else {
            boolean flag = false; //깨지지않은 계란이 없는지 확인
            for (int i = 0; i < N; i++) {

                if (i == start) continue;
                if (status[i] <= 0) continue; //깨진 계란이라면 넘어간다
                flag = true; //여기 왔다면 깨지지않은 계란이 하나쯤은 있다는 것

                status[start] -= eggs[i][1];
                status[i] -= eggs[start][1];

                hitEgg(start + 1);

                status[start] += eggs[i][1];
                status[i] += eggs[start][1];
            }

            if (!flag) {//깨지지 않은 다른 계란이 없으면 넘어간다.
                hitEgg(start + 1);
            }
        }

    }
}
