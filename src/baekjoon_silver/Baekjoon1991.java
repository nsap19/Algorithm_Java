package baekjoon_silver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int left;
    int right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Baekjoon1991 {
    static Node[] list;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); //노드의 갯수
        list = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0) - 'A';
            int left = -1, right = -1;
            char temp = st.nextToken().charAt(0);
            if (temp != '.') left = temp - 'A';
            temp = st.nextToken().charAt(0);
            if (temp != '.') right = temp - 'A';

            list[node] = new Node(left, right);
        }


        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        sb.append("\n");

        System.out.println(sb);
    }

    private static void preOrder(int root) {
        sb.append((char) (root + 'A'));
        if (list[root].left != -1) {
            preOrder(list[root].left);
        }
        if (list[root].right != -1) {
            preOrder(list[root].right);
        }
    }

    private static void inOrder(int root) {
        if (list[root].left != -1) {
            inOrder(list[root].left);
        }

        sb.append((char) (root + 'A'));

        if (list[root].right != -1) {
            inOrder(list[root].right);
        }
    }

    private static void postOrder(int root) {
        if (list[root].left != -1) {
            postOrder(list[root].left);
        }

        if (list[root].right != -1) {
            postOrder(list[root].right);
        }

        sb.append((char) (root + 'A'));
    }
}
