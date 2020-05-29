package etc;

import java.io.*;
import java.util.Stack;

public class kakao_winter_internship2019_1 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));

    }
    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for(int i = 0; i < moves.length; i++){
            int temp = 0;
            for(int j = 0; j < board.length; j++){
                if(board[j][moves[i]-1] != 0){
                    temp = board[j][moves[i]-1];
                    //
                    if(stack.size()>0 && stack.peek()==temp) {
                        answer+=2;
                        stack.pop();
                    }
                    else stack.push(temp);
                    //
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }

            //위의 부분과 위치차이만 있는 것 같은데 왜 틀린건지 모르겠음
//            if(stack.size()>0 && stack.peek()==temp) {
//                answer+=2;
//                stack.pop();
//                System.out.println(temp);
//            }
//            else stack.push(temp);

        }
        return answer;
    }
}
