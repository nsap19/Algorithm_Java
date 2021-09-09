package baekjoon_gold;

/**
 * 한 도시에서 D(1 <= D <= 1,000) 달러만 벌 수 있다는 규칙을 부과했습니다.
 * 그러나 Bessie는 잠시 동안 다른 곳에서 일한 후 도시로 돌아갈 수 있으며 해당 도시에서 최대 D 달러를 다시 벌 수 있습니다.
 * Bessie가 할 수 있는 횟수에는 제한이 없습니다.
 * <p>
 * Bessie의 세계는 편리하게 1..C로 번호가 매겨진 C(2 <= C <= 220) 도시를 연결하는 P(1 <= P <= 150) 일방통행 경로로 구성됩니다.
 * Bessie는 현재 도시 S(1 <= S <= C)에 있습니다.
 * 경로 i는 도시 A_i에서 도시 B_i(1 <= A_i <= C; 1 <= B_i <= C)까지 단방향으로 달리고 통과하는 데 비용이 들지 않습니다.
 * <p>
 * 베시를 돕기 위해 농부 존은 베시에게 그의 개인 제트기 서비스를 제공할 것입니다.
 * 이 서비스는 F(1 <= F <= 350) 노선을 제공하며,
 * 각 노선은 한 도시 J_i에서 다른 K_i(1 <= J_i <= C; 1 <= K_i <= C)로의 편도 비행이며
 * 비용은 T_i(1 <= T_i <= 50,000) 달러입니다. Besie는 현금이 없는 경우 향후 수입으로 티켓 비용을 지불할 수 있습니다.
 * <p>
 * 베시는 그녀가 원할 때 언제 어디서나 은퇴를 선택할 수 있습니다.
 * 시간이 무제한이라면 Bessie가 여행할 수 있는 각 도시에서 전체 D 달러를 벌 수 있다고 가정할 때 가장 많이 벌 수 있는 돈은 얼마입니까?
 * 이 금액에 제한이 없으면 -1을 인쇄합니다.
 */

import java.io.*;
import java.util.*;

class Work {
    int city;
    int cost;

    public Work(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }
}

public class Baekjoon6002 {
    static int D, P, C, F, S;
    static List<Work>[] list;
    static int[] distance;
    static int minus = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //1행: 공백으로 구분된 5개의 정수: D, P, C, F, S
        st = new StringTokenizer(br.readLine(), " ");
        D = Integer.parseInt(st.nextToken()); //한 도시에서 벌수 있는 돈
        P = Integer.parseInt(st.nextToken()); //도시를 연결하는 경로의 갯수
        C = Integer.parseInt(st.nextToken()); //도시의 갯수
        F = Integer.parseInt(st.nextToken()); //제트기로 갈수 있는 노선의 갯수
        S = Integer.parseInt(st.nextToken()); //출발 도시 번호

        list = new List[C + 1];
        distance = new int[C + 1];
        visited = new boolean[C+1];
        Arrays.fill(distance, 0);
        for (int i = 1; i <= C; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(new Work(end, D));
        }
        for (int i = 0; i < F; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Work(end, -cost));
        }

        boolean result = getMaxCost();
//            Arrays.sort(distance);
////        System.out.println(Arrays.toString(distance));
//        if(!result) System.out.println(-1);
//        else {
//            Arrays.sort(distance);
//            System.out.println((distance[C]+1)*D+minus);
//        }

        Arrays.sort(distance);
        if (distance[C] + 1 > C + 1) System.out.println(-1);//순환이 있다면
        else {
            System.out.println((distance[C] + 1) * D + minus);

        }

    }

    private static boolean getMaxCost() {
        Queue<Work> q = new LinkedList<>();
        distance[S] = D;
        q.add(new Work(S, D));
        visited[S] = true;
        boolean isUpdate = false;

        loop: while (!q.isEmpty()) {
            Work curNode = q.poll();
            int city = curNode.city;

            for (Work next : list[city]) {
                if(visited[next.city] && next.cost < 0) continue;
                if (distance[next.city] < distance[city] + next.cost) {
                    distance[next.city] = distance[city] + next.cost;
                    q.add(new Work(next.city, distance[next.city]));
                    if (next.cost < 0) minus += next.cost;
                }
                System.out.println(city + "->" + next.city);
                System.out.println(Arrays.toString(distance));
            }

        }
//        loop:
//        for (int i = 1; i <= C; i++) {
//            isUpdate = false;
//            int city = i;
//
//            for (Node next : list[city]) {
//                if (distance[next.city] < distance[city] + 1) {
//                    distance[next.city] = distance[city] + 1;
//                    isUpdate = true;
//                    if (next.cost < 0) minus += next.cost;
//
//
////                    if(i==C) {
////                        isUpdate = true;
////                        break loop;
////                    }
//                }
//                System.out.println(city + "->" + next.city);
//                System.out.println(Arrays.toString(distance));
//            }
//        }

//        if(isUpdate) return false;
        if(isUpdate) return false;
        return true;
    }


}
