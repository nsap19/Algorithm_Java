package etc.programmers_Lv2;

import java.io.*;
import java.util.*;

public class Programmers_Lv2_7 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
//        System.out.println(solution("CBD", new String[]{"BACDE"}));

    }

    public static int solution(String skill, String[] skill_trees) {
        //내 풀이
        int answer = 0;
        int[] skillNum = new int[26];

        int temp = 1;
        for (int i = 0; i < skill.length(); i++) {
            skillNum[skill.charAt(i) - 'A'] = temp;
            temp++;
        }

        for (int i = 0; i < skill_trees.length; i++) {
            temp = 1;
            boolean result = true;
            String str = skill_trees[i];

            for (int j = 0; j < str.length(); j++) {
                if (skillNum[str.charAt(j) - 'A'] > temp) {
                    result = false;
                    break;
                }
                else if(skillNum[str.charAt(j) - 'A'] == temp) temp++;
            }
            if (result) answer++;
        }
        return answer;


        //다른 풀이
        /*
        int answer = 0;

        ArrayList<String> skillTrees = new ArrayList<>(Arrays.asList(skill_trees));
        Iterator<String> it = skillTrees.iterator();

        while (it.hasNext()) {
//            it.next().replaceAll("[^" + skill + "]", "")); //[^skill] - skill 문자열 제외 공백처리
//            skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) //skill에서 위 문자열이 나타나는 위치 index를 리턴
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;

         */
    }

}
