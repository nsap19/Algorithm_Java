/* 완주하지 못한 선수

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

제한사항
마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.

    participant     |   completion  |   return
    [leo, kiki, eden]   |   [eden, kiki]    |   leo
    [marina, josipa, nikola, vinko, filipa] |   [josipa, filipa, marina, nikola]    |   vinko
    [mislav, stanko, mislav, ana]   |   [stanko, ana, mislav]   |   mislav
* */
package etc.programmers_Lv1;

import java.io.*;
import java.util.Arrays;

public class Programmers_Lv1_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] participant = br.readLine().split(", ");
        String[] completion = br.readLine().split(", ");
        bw.write(solution(participant, completion));
        bw.close();
    }

    public static String solution(String[] participant, String[] completion) {
            //hash를 사용한 풀이
//         HashMap<String, Integer> map = new HashMap<>();

//         for(String arg : participant) map.put(arg, map.getOrDefault(arg,0)+1);

//         for(String arg : completion) map.put(arg, map.get(arg)-1);

//         for(String key : map.keySet()){
//             if(map.get(key) != 0) return key;
//         }

//         return null;

        //기존 내 풀이
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for(i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }

        return participant[i];
    }
}


