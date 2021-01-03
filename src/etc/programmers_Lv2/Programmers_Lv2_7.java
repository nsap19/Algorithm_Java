package etc.programmers_Lv2;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_Lv2_7 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
//        System.out.println(solution("CBD", new String[]{"BACDE"}));

    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] skillNum = new int[26];

        int temp = 1;
        for (int i = 0; i < skill.length(); i++) {
            skillNum[skill.charAt(i) - 'A'] = temp;
            temp++;
        }

//        System.out.println(Arrays.toString(skillNum));

        for (int i = 0; i < skill_trees.length; i++) {
            temp = 1;
            boolean result = true;
            String str = skill_trees[i];

            for (int j = 0; j < str.length(); j++) {
//                System.out.println(skillNum[str.charAt(j)-'A'] +" "+ temp);
                if (skillNum[str.charAt(j) - 'A'] > temp) result = false;
                else temp++;
            }
            if (result) answer++;
        }
        return answer;
    }

}
