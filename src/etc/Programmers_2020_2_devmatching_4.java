package etc;

import java.io.*;
import java.util.*;

public class Programmers_2020_2_devmatching_4 {
    static class Vote implements Comparable<Vote> {
        String name;
        int count;

        public Vote(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(Vote o) {
            if (count == o.count) return o.name.compareTo(name);
            return count - o.count;
        }


        @Override
        public String toString() {
            return name + " / " + count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] votes = br.readLine().split(", ");
        int k = Integer.parseInt(br.readLine());

        //case 1 : 기업명과 득표수를 hashmap으로 표현한 후, priority queue로 정렬 - 상위 k개의 득표수 구하는데 어려움이 생
        /*HashMap<String, Integer> vote_count = new HashMap<>();

        for (int i = 0; i < votes.length; i++) {
            if (vote_count.containsKey(votes[i])) {
                vote_count.put(votes[i], vote_count.get(votes[i]) + 1);
            } else vote_count.put(votes[i], 1);
        }

        PriorityQueue<Vote> pq = new PriorityQueue<>();
        int top = 0;
        int temp = vote_count.size();
        for (String key : vote_count.keySet()) {
            Vote vote = new Vote(key, vote_count.get(key));
            pq.add(vote);
        }

        temp = 0;
        String last = "";
        while (!pq.isEmpty()) {
            temp += pq.peek().count;
            last = pq.poll().name;
            if (temp >= top) break;
        }

        bw.close();
         */


        //case 2김 : 기업명과 득표수의 배열을 따로 표현
        Arrays.sort(votes);
        ArrayList<String> c_name = new ArrayList(); //기업명
        ArrayList<Integer> c_vote = new ArrayList(); //기업별 득표수

        int v_count = 1;
        for (int i = 1; i < votes.length; i++) {
            if(!votes[i].equals(votes[i-1])){
                c_name.add(votes[i-1]);
                c_vote.add(v_count);
                v_count=1;
            }
            else v_count++;
        }

//        System.out.println(c_name.size());
//        System.out.println(c_vote.size());
        for (int i = 0; i < c_name.size(); i++) {
            System.out.println(c_name.get(i)+" / "+c_vote.get(i));
        }
    }
}

