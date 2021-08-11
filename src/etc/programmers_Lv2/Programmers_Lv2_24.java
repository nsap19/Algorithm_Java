package etc.programmers_Lv2;

import java.util.*;

public class Programmers_Lv2_24 {

    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french")); //16384
    }

    private static int solution(String str1, String str2) {
        double result = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        ArrayList<String> str1List = new ArrayList<>();
        ArrayList<String> str2List = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>(); //합집합
        ArrayList<String> inter = new ArrayList<>();//교집합

        inputList(str1, str1List);
        inputList(str2, str2List);
        if (str1List.size() == 0 && str2List.size() == 0) return 65536;

        Collections.sort(str1List);
        Collections.sort(str2List);

        for(String str : str1List){
            if(str2List.remove(str)){ //삭제가 된다는 건 교집합 원소라는 것
                inter.add(str);
            }
            union.add(str); //교집합 원소들도 합집합의 원소
        }
        // 이 과정 거치고 나면 차집합만 남음 (합집합 = 차집합 + 교집합)

        for (String str: str2List){
            union.add(str);
        }
        System.out.println(inter.size());
        System.out.println(union.size());
        result = (double)inter.size()/union.size() * 65536;

        return (int)result;
    }

    private static void inputList(String str, ArrayList<String> list) {
        char temp1;
        char temp2;
        for (int i = 0; i < str.length() - 1; i++) {
            temp1 = str.charAt(i);
            temp2 = str.charAt(i + 1);
            if (Character.isLetter(temp1) && Character.isLetter(temp2)) {
                list.add(temp1 + "" + temp2);
            }
        }
    }

}
