package baekjoon_gold;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
입력
첫째 줄에 테스트 케이스의 개수 t가 주어진다. (1 ≤ t ≤ 50) 각 테스트 케이스의 첫째 줄에는 전화번호의 수 n이 주어진다. (1 ≤ n ≤ 10000)
다음 n개의 줄에는 목록에 포함되어 있는 전화번호가 하나씩 주어진다. 전화번호의 길이는 길어야 10자리이며, 목록에 있는 두 전화번호가 같은 경우는 없다.

출력
각 테스트 케이스에 대해서, 일관성 있는 목록인 경우에는 YES, 아닌 경우에는 NO를 출력한다.
* */
// 도저히 감이 안잡혀서 약간을 참고해보니 트라이 자료구조를 사용해야한다고 하더라,,,
// 트라이는 문자열에서의 검색을 빠르게 해주는 자료구조
// 기본적인 트라이 설계는 인터넷 참고

//해시맵의 value를 또다른 TrieNode로 지정 -> Node의 링크 필드와 같은 개념으로 보면 될 것 같다.
//그래도 어렵다,,, 이해가 잘 안감,,,
class TrieNode {
    private HashMap<Character, TrieNode> childNodes = new HashMap<>();//자식 노드
    private boolean isLast; //마지막 글자인지 확인

    public HashMap<Character, TrieNode> getChildNodes() {
        return childNodes;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }


    @Override
    public String toString() {
        return "TrieNode{" +
                "childNodes=" + childNodes.keySet() +
                '}';
    }
}

class Trie {
    private TrieNode rootNode;

    Trie() {
        rootNode = new TrieNode();
    }

    void insert(String word) {
        TrieNode thisNode = this.rootNode;
        for (int i = 0; i < word.length(); i++) {
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        thisNode.setLast(true);
    }

    boolean contain(String word) {
        TrieNode thisNode = this.rootNode;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = thisNode.getChildNodes().get(c);
//            System.out.println(c);
//            System.out.println(node.toString());
//            System.out.println();

            if (node == null) return false; //해당 단어가 존재하지 않으므로 false

            thisNode = node;
        }

        if (thisNode.isLast()) {
            if (!thisNode.getChildNodes().isEmpty()) //마지막이라고 표시되어있는 노드에 자식 노드가 더 있는 경우 false
                return false;
        }

        return true;
    }
}

public class Baekjoon5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); //테스트 케이스
        for (int i = 0; i < t; i++) {

            int n = Integer.parseInt(br.readLine());//전화번호 갯수
            String[] arr = new String[n];
            Trie trie = new Trie();

            for (int j = 0; j < n; j++) {
                String str = br.readLine();
                arr[j] = str;
                trie.insert(str);
            }

            boolean check = false;
            for (int j = 0; j < n; j++) {
                String str = arr[j];
                check = trie.contain(str);

                if (!check) break;
            }

            if (!check) sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.println(sb);

    }
}
