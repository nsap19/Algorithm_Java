package etc.programmers_Lv3;


import java.util.*;

public class Programmers_Lv3_1 {
    public static void main(String[] args){
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
        //[4, 1, 3, 0]
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer;
        ArrayList<Integer> result = new ArrayList<>();
        //장르이름, 장르별 재생횟수
        Map<String, Integer> genre_count = new HashMap<>();

        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            genre_count.put(genre, genre_count.getOrDefault(genre , 0) + play);
        }

        //장르별 정렬 - 내림차순
        ArrayList<String> list1 = new ArrayList<>(genre_count.keySet());
        Collections.sort(list1, (o1, o2) -> (genre_count.get(o2).compareTo(genre_count.get(o1))));

        //정렬한 장르별 곡 재생횟수 정렬
        for(String genre : list1){
            //고유번호, 재생횟수
            Map<Integer, Integer> count = new HashMap<>();

            for(int i=0; i<genres.length; i++)
                if(genres[i].equals(genre)) count.put(i, plays[i]);

            //재생횟수 정렬 - 내림차순
            ArrayList<Integer> list = new ArrayList<>(count.keySet());
            Collections.sort(list,(o1, o2) -> (count.get(o2).compareTo(count.get(o1))));


            int j = 0;
            for (Integer c : list) {
                if(j>1)
                    break;
                result.add(c);
                j++;
            }
        }

        answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
}
