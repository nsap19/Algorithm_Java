package etc;

public class kakao_internship2020_1 {
    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand="left";
        String result="LRLLRRLLLRR";
        String myresult=solution(numbers, hand);
        System.out.println(myresult);
        System.out.println(result);
        if(myresult.equals(result))System.out.println(true);
        else System.out.println(false);
        //{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, right : LRLLLRLLRRL
        //{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, left : LRLLRRLLLRR
        //{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, right : LLRLLRLLRL
    }
        public static String solution(int[] numbers, String hand) {
            String answer = "";
            String lastRight = "#";
            String lastLeft = "*";

            for(int i = 0; i < numbers.length ; i++){
                System.out.println("num:"+numbers[i]);

                String answer2="";
                int Rlength = 0;
                int Llength = 0;
                if(numbers[i]==1 || numbers[i]==4 ||numbers[i]==7){
                    answer2 ="L";
                    lastLeft = String.valueOf(numbers[i]);
                }
                else if(numbers[i]==3 || numbers[i]==6||numbers[i]==9){
                    answer2 = "R";
                    lastRight = String.valueOf(numbers[i]);
                }
                else{
                    Rlength = getLength(lastRight, numbers[i]);
                    Llength = getLength(lastLeft, numbers[i]);

                    System.out.println("lastRight:"+lastRight);
                    System.out.println("lastLeft:"+lastLeft);
                    System.out.println("R:"+Rlength);
                    System.out.println("L:"+Llength);


                    if(Rlength < Llength) {
                        answer2 ="R";
                        lastRight = String.valueOf(numbers[i]);
                    }
                    else if(Llength < Rlength){
                        answer2 = "L";
                        lastLeft = String.valueOf(numbers[i]);
                    }
                    else if(Llength == Rlength){
                        if(hand.equals("right")){
                            answer2 = "R";
                            lastRight = String.valueOf(numbers[i]);
                        }
                        else {
                            answer2 = "L";
                            lastLeft = String.valueOf(numbers[i]);
                        }
                    }
                }
                System.out.println(answer2);
                answer += answer2;
            }


            return answer;
        }

        private static int getLength(String last, int num){
            int length;


            if(last.equals("#")) last = "0";
            else if(last.equals("*")) last = "0";

            if(last.equals("0")) last = "11";

            if(num == 0) num=11;

            length = Integer.parseInt(last) - num;
            if(length < 0) length *= -1;
            length = (length/3) + (length%3);
//            if(num==11) length ++;
//            else
                if(last.equals("11")) length--;

            if(length == 0) length=1;

            return length;
        }

}
