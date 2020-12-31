package etc;

import java.io.*;
import java.util.*;

public class Programmers_2020_2_devmatching_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] votes = br.readLine().split(", ");
        int k = Integer.parseInt(br.readLine());

        HashMap<String, Integer> vote_count = new HashMap<>();

        for (int i = 0; i < votes.length; i++) {
            if (vote_count.containsKey(votes[i])) {
                vote_count.put(votes[i], vote_count.get(votes[i]) + 1);
            } else vote_count.put(votes[i], 1);
        }


        List<String> voteList = new ArrayList<>(vote_count.keySet());
        Collections.sort(voteList); //이름순 정렬
        Collections.sort(voteList, ((o1, o2) -> vote_count.get(o2).compareTo(vote_count.get(o1)))); //둑표수 별 정렬

        //정렬 확인
//        for(String key : voteList) {
//            System.out.println(key + " / " + vote_count.get(key));
//        }

        //상위 k개 자동차의 득표수 구하기
        int top = 0;
        for (int i = 0; i < k; i++) {
            top += vote_count.get(voteList.get(i));
        }

        for (int i = vote_count.size() - 1; i >= 0; i--) {
            top -= vote_count.get(voteList.get(i));
//            System.out.println(top+voteList.get(i));
            if (top <= 0) {
                System.out.println(voteList.get(i + 1));
                break;
            }
        }
    }
}

