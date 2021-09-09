package baekjoon_gold;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Computer implements Comparable<Computer> {
    int comp;
    int line;

    public Computer(int comp, int line) {
        this.comp = comp;
        this.line = line;
    }

    @Override
    public int compareTo(Computer o) {
        return this.line - o.line;
    }
}

public class Baekjoon1922 {
    static ArrayList<Computer>[] list;
    static int[] minLine;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

//        첫째 줄에 컴퓨터의 수 N (1 ≤ N ≤ 1000)가 주어진다.
//둘째 줄에는 연결할 수 있는 선의 수 M (1 ≤ M ≤ 100,000)가 주어진다.
//셋째 줄부터 M+2번째 줄까지 총 M개의 줄에 각 컴퓨터를 연결하는데 드는 비용이 주어진다.
// 이 비용의 정보는 세 개의 정수로 주어지는데, 만약에 a b c 가 주어져 있다고 하면 a컴퓨터와 b컴퓨터를 연결하는데 비용이 c (1 ≤ c ≤ 10,000) 만큼 든다는 것을 의미한다.
// a와 b는 같을 수도 있다.

        int N = Integer.parseInt(br.readLine()); //컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); //연결할수있는 선의 수

        list = new ArrayList[N + 1];
        minLine = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Computer(b, c));
            list[b].add(new Computer(a, c));
        }

        getMinLine();
        System.out.println(result);

    }

    private static void getMinLine() {
        Arrays.fill(minLine, Integer.MAX_VALUE);
        PriorityQueue<Computer> queue = new PriorityQueue<>();
        queue.add(new Computer(1, 0));
        minLine[1] = 0;

        while (!queue.isEmpty()) {
            Computer computer = queue.poll();
            int cur = computer.comp;

            if (visited[cur]) continue;
            visited[cur] = true;

            result += computer.line;

            for (Computer com : list[cur]) {
                if (minLine[com.comp] > com.line) {
                    minLine[com.comp] = com.line;
                    queue.add(new Computer(com.comp, minLine[com.comp]));
                }
            }
        }
    }
}
