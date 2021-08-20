package baekjoon_gold;

import java.io.*;
import java.util.*;

class House {
    int r;
    int c;

    public House(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Baekjoon15686 {
    static int N, M, totalMin = Integer.MAX_VALUE;
    static ArrayList<House> homes, chickens;
    static House[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // N x N 크기의 도시
        M = Integer.parseInt(st.nextToken()); //폐업시키지 않을 치킨집은 최대 M개

        //도시의 치킨 거리는 모든 집의 치킨 거리의 합.
        //도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다. 어떻게 고르면, 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램을 작성하시오.
        chickens = new ArrayList<>();
        homes = new ArrayList<>();
        result = new House[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                // 0은 빈 칸, 1은 집, 2는 치킨집
                if (num == 2) chickens.add(new House(i, j));
                else if (num == 1) homes.add(new House(i, j));
            }
        }

        combi(0, 0);

        System.out.println(totalMin);
    }

    private static void combi(int cnt, int start) {
        if (cnt == M) {
            int len = getCityChickenDist(result);
            totalMin = Math.min(len, totalMin);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            result[cnt] = chickens.get(i);
            combi(cnt + 1, i + 1);
        }

    }

    private static int getCityChickenDist(House[] combi) {
        int sum = 0;

        //각 집별로 모든 치킨집의 거리를 구해서 가장 작은 거리를 치킨거리로 저장
        for (int i = 0; i < homes.size(); i++) {
            House home = homes.get(i);
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < combi.length; j++) {
                House chicken = combi[j];
                int len = Math.abs(chicken.r - home.r) + Math.abs(chicken.c - home.c);

                min = Math.min(len, min);
            }

            sum += min;
        }

        return sum;
    }
}
