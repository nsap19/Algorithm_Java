package etc;

import java.io.*;

public class kakao_blind_2020_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(solution(br.readLine())));
        bw.close();
    }

    public static int solution(String s) {
        int answer= s.length();

        for (int n = 1; n <= s.length() / 2; n++) {
            String result = "";

            for (int i = 0; i < s.length(); i += n) {
                String word;

                if (i + n >= s.length()) word = s.substring(i);
                else word = s.substring(i, i + n);

                int count = 1;

                for (int j = i + n; j < s.length(); j += n) {
                    String word2;

                    if (j + n >= s.length()) word2 = s.substring(j);
                    else word2 = s.substring(j, j + n);

                    if (word.equals(word2)) {
                        count++;
                        i = j;
                    } else break;
                }

                if (count == 1) result += word;
                else result += (count + word);
            }

            answer = Math.min(answer, result.length());
        }

        return answer;
    }

    //다른사람의 풀이 - 처리속도가 엄청 빠름
//    public static int solution(String s){
//        int min = s.length();
//        int len = s.length()/2+1;
//        for(int i = 1; i < len; i++) {
//            String before = "";
//            int sum = 0;
//            int cnt = 1;
//            for(int j = 0; j < s.length();) {
//                int start = j;
//                j = (j+i > s.length()) ? s.length():j+i;
//                String temp = s.substring(start, j);
//                if(temp.equals(before)) {
//                    cnt++;
//                } else {
//                    if(cnt != 1) {
//                        sum += (int)Math.log10(cnt)+1;
//                    }
//                    cnt = 1;
//                    sum+=before.length();
//                    before = temp;
//                }
//            }
//            sum+=before.length();
//            if(cnt != 1) {
//                sum += (int)Math.log10(cnt)+1;
//            }
//            min = (min > sum) ? sum : min;
//        }
//
//        return min;
//    }
}

