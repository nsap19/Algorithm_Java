package etc;

import java.util.*;

public class Programmers_2020_devmatching_1 {

        public int solution(String p, String s) {
            String[] p_arr=p.split("");
            String[] s_arr=s.split("");
            int answer=0;


            for(int i=0; i< p_arr.length; i++){
                int temp = Math.abs(Integer.parseInt(p_arr[i])-Integer.parseInt(s_arr[i]));
                if(temp > 5) {
                    temp = 10-temp;
                }
                answer += temp;
            }
            return answer;
        }


}
