/* 벨만포드 - 웜홀 문제 (참고 - https://devowen.com/250, https://dragon-h.tistory.com/24)

    1. 간선의 시작점(start), 끝점(end), 가중치(cost)가 들어간 Road 클래스를 만든 후 이 road들을 배열(roads)에 다 담았다.(웜홀 포함)
    2. 각각의 node들은 시작 지점(1이라고 가정)에서 최단 경로를 의미하며 INF로 초기화했다. 단, 시작지점의 값은 0으로 한다.
    3. isUpdated는 업데이트가 하나라도 일어나는지를 판단하는 boolean 값이다.
        false로 시작해서, 한 번의 edge relocaion에서 한 번이라도 update가 일어나면 true값으로 바뀌고
        매 번 edge relocation이 진행될 때 마다 false로 초기화된다.
        만약 어떤 edge relocation이 끝났는데 isUpdated = false 라면 그 때 업데이트가 일어나지 않았다는 의미이므로 edge relocation을 조기 종료 한다.
    4. negative cycle 체크는 N 번째 edge relocation에서 일어나도록 했다.
        (원래 edge relocation은 N-1 번까지 해야 맞는데, N-1 번째 이후에 계속 루프가 돈다는 의미는 계속해서 사이클을 돌 때 마다 업데이트가 되고 있다는 의미이다.)
        이 때 만약 update가 일어나면 이 그래프는 negative cycle을 가지고 있는 그래프고
        이 문제에서 "YES", 즉 시간이 줄어들며 출발점으로 돌아올 수 있다는 결과를 반환해야 한다. 그렇지 않은 경우는 "NO"를 반환한다.
*/
package baekjoon_step29;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1865 {
    static class Road {
        int start, end, cost;

        public Road(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "start : " + start + ", end : " + end + ", cost : " + cost;
        }
    }

    private static int INF = 500 * 10_000;
    static int n, m, w;
    static Road[] roads;
    static int[] dist;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCnt; i++) {
            init();

            if (bellmanFord()) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.close();
    }

    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        roads = new Road[2 * m + w]; //무방향인 도로이므로 도로의 갯수 * 2 + 웜홀의 갯수(웜홀은 방향이 정해져있기 때문)

        int index = 0; //roads의 인덱스

        for (int i = 0; i < m + w; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            //무방향이기 때문에 양쪽 다 추가해줌
            if (i < m) {
                roads[index++] = new Road(start, end, cost);
                roads[index++] = new Road(end, start, cost);
            } else { //유방향인 웜홀은 cost에 -1을 곱해줌
                roads[index++] = new Road(start, end, cost * -1);
            }
        }
    }

    static boolean bellmanFord() {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean isUpdate = false;

        loop1:
        // N-1 Edge Relaxation
        for (int i = 1; i <= n; i++) {
            isUpdate = false;
//            System.out.println(i);

            for (Road road : roads) { // edge개수 만큼 확인을 한다.
//                System.out.println(road.toString());
//                System.out.println("기존값 : "+ dist[road.end]+", 신규값 : " +dist[road.start]+" + "+ road.cost+" = "+(dist[road.start]+road.cost));

                if (dist[road.end] > dist[road.start] + road.cost) {
                    dist[road.end] = dist[road.start] + road.cost;
                    isUpdate = true;

                    // Negative Cycle
                    if (i == n) {
                        isUpdate = true;
                        break loop1;
                    }
                }
            }
//            System.out.println(isUpdate);
            if (!isUpdate) break;
        }
        return isUpdate;
    }
}
