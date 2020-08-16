/* 18번의 출력 초과 끝에 찾아낸 오류 - dist배열을 int가 아닌 long배열로 해줘야 한다......*/
package baekjoon_step29;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11657 {
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
    static int n, m;
    static Road[] roads;
    static long[] dist;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new long[n + 1];
        roads = new Road[m];
        Arrays.fill(dist, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            roads[i] = new Road(start, end, cost);
        }

        StringBuilder sb = new StringBuilder();

        if (!bellmanFord()) { //음의 cycle이 없는 경우
            for (int i = 2; i <= n; i++) {
                sb.append(dist[i] == INF ? "-1\n" : dist[i] + "\n"); //해당도시로 가는 경로가 없다면 -1, 있다면 최소 경로 출력
            }
        } else sb.append("-1\n");
        //음의 cycle이 있는 경우(1번 도시에서 출발해 어떤 도시로 가는 과정에서 시간을 무한히 오래 전으로 되돌릴 수 있다면) -1 출력

        bw.write(sb.toString());
        bw.close();
    }

    static boolean bellmanFord() {
        dist[1] = 0;
        boolean isUpdate = false; //음의 cycle 여부 - 음의 cycle이 있다면 true, 없다면 false 리턴

        loop1:
        // N-1 Edge Relaxation
        for (int i = 1; i <= n; i++) {
            isUpdate = false;
//            System.out.println(i);

            for (Road road : roads) { // edge개수 만큼 확인을 한다.
//                System.out.println(road.toString());
//                System.out.println("기존값 : "+ dist[road.end]+", 신규값 : " +dist[road.start]+" + "+ road.cost+" = "+(dist[road.start]+road.cost));

                if (dist[road.start] == INF) continue;
                if (dist[road.end] > dist[road.start] + road.cost) {
                    dist[road.end] = dist[road.start] + road.cost;

                    // Negative Cycle
                    if (i == n) {
                        isUpdate = true;
                        break loop1;
                    }
                }
            }
        }
        return isUpdate;
    }
}


