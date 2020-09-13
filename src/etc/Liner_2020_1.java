package etc;

import java.util.*;

public class Liner_2020_1 {
    public static void main(String[] args){
        int[][] boxes1 = {{1,2}, {2,1},{3,3}, {4,5},{5,6},{7,8}}; //2
        int[][] boxes2 = {{1,2},{3,4},{5,6}}; //3
        int[][] boxes3 = {{1,2},{2,3},{3,1}}; //0
        System.out.println(solution(boxes1));
        System.out.println(solution(boxes2));
        System.out.println(solution(boxes3));

    }

    public static int solution(int[][] boxes) {
        ArrayList<Integer> list = new ArrayList<>();
        int match = 0;

        for (int i = 0; i < boxes.length; i++) {
            int goods1 = boxes[i][0];
            int goods2 = boxes[i][1];

            if (goods1 == goods2) {
                match++;
                continue;
            }

            if (list.size() > 0 && list.contains(goods1)) {
                list.remove(Integer.valueOf(goods1));
                match++;
            } else list.add(goods1);

            if (list.size() > 0 && list.contains(goods2)) {
                list.remove(Integer.valueOf(goods2));
                match++;
            } else list.add(goods2);

        }
        return boxes.length - match;
    }
}



