package baekjoon_step8;

import java.util.Scanner;

public class Baekjoon1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //단어의 갯수
        int result = 0;
        int r = 0;

        for (int i = 0; i < n; i++) {
            String[] word = sc.next().split("");

            if (word.length == 1) {
                r = 1;
            } else {
                Loop1:
                for (int j = 0; j < word.length; j++) {
                    for (int k = j + 1; k < word.length; k++) {
                        if (word[j].equals(word[k]) && !word[k].equals(word[k - 1])) {
                            r = 0;
                            break Loop1;
                        } else {
                            r = 1;
                        }
                    }
                }
            }
            result += r;
        }

        System.out.println(result);
    }
}
