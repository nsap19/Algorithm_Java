package baekjoon_step29;

import java.io.*;
import java.util.*;

public class Baekjoon10217 {
    static class Airplane implements Comparable<Airplane> {
        int end, cost, time; //도착, 비용, 소요시간

        public Airplane(int end, int cost, int time) {
            this.end = end;
            this.cost = cost;
            this.time = time;
        }

        @Override
        public int compareTo(Airplane o) {
            if (this.time == o.time) return cost - o.cost;
            return this.time - o.time;
        }
    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 100 * 1_000;
    static int n, m, k;
    static List<Airplane>[] list;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int T = 0; T < t; T++) {
            init();
            int result = dijkstra();
            sb.append(result != INF ? result + "\n" : "Poor KCM\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    public static int dijkstra() {
        PriorityQueue<Airplane> queue = new PriorityQueue<>();
        queue.add(new Airplane(1, 0, 0));
        dp[1][0] = 0;

        while (!queue.isEmpty()) {
            Airplane airplane = queue.poll();
            int node = airplane.end;
            int cost = airplane.cost;
            int time = airplane.time;

            if (node == n) break;
            if (dp[node][cost] < time) continue;
            dp[node][cost] = time;

            for (int i = 0; i < list[node].size(); i++) {
                Airplane toAirplane = list[node].get(i);
                int toNode = toAirplane.end;
                int toCost = cost + toAirplane.cost;
                int toTime = time + toAirplane.time;

                if (toCost > m) continue;
                if (dp[toNode][toCost] > toTime) { //불필요한 push를 막기 위함
                    for (int j = toCost; j <= m; j++) {
                        if (dp[toNode][j] > toTime) dp[toNode][j] = toTime;
                    }
                    queue.add(new Airplane(toNode, toCost, toTime));
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 1; i <= m; i++)
            result = Math.min(result, dp[n][i]);

        return result;
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //공항의 수
        m = Integer.parseInt(st.nextToken()); //총 지원 비용
        k = Integer.parseInt(st.nextToken()); //티켓 정보의 수

        dp = new int[n + 1][m + 1];
        list = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], INF);

        for (int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();


        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list[start].add(new Airplane(end, cost, time));
        }
    }
}
