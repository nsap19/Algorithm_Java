package etc;

public class kakao_internship2020_1 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand="right";
        System.out.println(solution(numbers, hand));
    }
        public static String solution(int[] numbers, String hand) {
            String answer = "";
            String lastRight = "#";
            String lastLeft = "*";

            for(int i = 0; i < numbers.length ; i++){
                int Rlength = 0;
                int Llength = 0;
                if(numbers[i]==1 || numbers[i]==4 ||numbers[i]==7){
                    answer +="L";
                    lastLeft = String.valueOf(numbers[i]);
                }
                else if(numbers[i]==3 || numbers[i]==6||numbers[i]==9){
                    answer +="R";
                    lastRight = String.valueOf(numbers[i]);
                }
                else{
                    if(lastRight=="#" || lastLeft=="*"){
                        Rlength = 0;
                        Llength = 0;
                    }
                    else{
                        Rlength = Integer.parseInt(lastRight) - numbers[i];
                        if(Rlength < 0) Rlength *= -1;
                        if(Rlength <=3) Rlength = 1;
                        if(Rlength > 3) Rlength = 2;
                        else if(Rlength > 6) Rlength = 3;
                        System.out.println("num:"+numbers[i]);
                        System.out.println("R:"+Rlength);

                        Llength = Integer.parseInt(lastLeft) - numbers[i];
                        if(Llength < 0) Llength *= -1;
                        if(Llength <=3) Llength = 1;
                        if(Llength > 3) Llength = 2;
                        else if(Llength > 6) Llength = 3;
                        System.out.println("L:"+Llength);
                    }

                    if(Rlength < Llength) {
                        answer +="R";
                        lastRight = String.valueOf(numbers[i]);
                    }
                    else if(Llength < Rlength){
                        answer += "L";
                        lastLeft = String.valueOf(numbers[i]);
                    }
                    else if(Llength == Rlength){
                        if(hand == "right"){
                            answer +="R";
                            lastRight = String.valueOf(numbers[i]);
                        }
                        else{
                            answer += "L";
                            lastLeft = String.valueOf(numbers[i]);
                        }
                    }
                }
            }


            return answer;
        }

}
