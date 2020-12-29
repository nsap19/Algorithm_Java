package etc;

import java.io.*;
import java.util.*;

public class Programmers_2020_2_devmatching_4 {
    static class Vote implements Comparable<Vote>{
        String name;
        int count;

        public Vote(String name, int count){
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
            return name + " / " + count ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] votes = br.readLine().split(", ");
        int k = Integer.parseInt(br.readLine());

        //기업명과 득표수 배열을 따로두는게 나을지도 ?

        HashMap<String, Integer> vote_count = new HashMap<>();

        for (int i = 0; i < votes.length; i++) {
            if(vote_count.containsKey(votes[i])){
                vote_count.put(votes[i], vote_count.get(votes[i])+1);
            }
            else vote_count.put(votes[i],1);
        }

        PriorityQueue<Vote> pq = new PriorityQueue<>();
        for(String key : vote_count.keySet()){
            Vote vote = new Vote(key, vote_count.get(key));
            pq.add(vote);
        }

        while(!pq.isEmpty()){
            System.out.println(pq.poll().toString());
        }
    }
}

