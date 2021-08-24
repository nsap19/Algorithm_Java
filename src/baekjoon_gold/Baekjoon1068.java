package baekjoon_gold;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] parents = new int[N];
        int root = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
            if (parents[i] == -1) root = i;
        }

        int remove = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(remove);
        parents[remove] = -1;

        //remove 자식 노드들 모두 제거 (-1로 표시)
        while (!queue.isEmpty()) {
            int find = queue.poll();

            for (int i = 0; i < N; i++) {
                if (parents[i] == find) {
                    queue.offer(i);
                    parents[i] = -1;
                }
            }
        }

        //리프노드 찾기
        int cnt = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int find = queue.poll();

            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if (parents[i] == find) { //find를 부모로 가진 노드 = find의 자식이 있다
                    queue.offer(i);
                    flag = true; //자식이 있다면 체크
                }
            }
            if (!flag) cnt++; //자식이 없다면 리프라는 뜻이므로 cnt++
        }

        if (remove == root) sb.append("0"); //루트를 제거하면 리프노드는 없으므로 0
        else sb.append(cnt);

        System.out.println(sb);
    }
}
