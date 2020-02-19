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

            if (word.length == 1) { //단어의 길이가 1개이면 자동적으로 그룹단어임
                r = 1;
            } else {
                Loop1:
                for (int j = 0; j < word.length; j++) { //한글자씩 기준이 됨
                    for (int k = j + 1; k < word.length; k++) { //기준의 다음 글자부터 비교
                        if (word[j].equals(word[k]) && !word[k].equals(word[k - 1])) { //기준글자의 뒤에 연속되지 않게 같은 글자가 있다면 0
                            r = 0; //그룹단어가 아님
                            break Loop1; //하나라도 0에 해당하면 해당 글자의 반복문(loop1으로 지정) break
                        } else {
                            r = 1; //그룹단어임
                        }
                    }
                }
            }
            result += r;
        }

        System.out.println(result);
    }
}
