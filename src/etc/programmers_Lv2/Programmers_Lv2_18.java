package etc.programmers_Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Programmers_Lv2_18 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));

    }

    private static String[] solution(String[] record) {
        String[] answer;
        ArrayList<String> list = new ArrayList<>();

        //[recod.length][3] 배열 만들기
        String[][] arr = new String[record.length][3];
        for (int i = 0; i < record.length; i++) {
            arr[i] = record[i].split(" ");
        }

        //멥을 통해 uid별 닉네임 저장
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < arr.length ; i++) {
            if(!arr[i][0].equals("Leave"))
                map.put(arr[i][1], arr[i][2]);
        }

        for (int i = 0; i < arr.length ; i++) {
            if(arr[i][0].equals("Enter")) {
                list.add(map.get(arr[i][1]) + "님이 들어왔습니다.");
            }
            else if(arr[i][0].equals("Leave"))
                list.add(map.get(arr[i][1])+"님이 나갔습니다.");
        }

        answer = list.toArray(new String[list.size()]);

        return answer;
    }
}
