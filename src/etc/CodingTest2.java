package etc;

import java.io.*;
import java.util.*;

public class CodingTest2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] lotto = input.split(" "); //오름차순 정렬된 배열
        String[] inputArr = input.split(" ");
        boolean result = true;

        Arrays.sort(lotto);

        for (int i = 0; i < lotto.length; i++) {
            int num = Integer.parseInt(inputArr[i]);

            if (i < inputArr.length - 1 && inputArr[i].equals(inputArr[i + 1])) { //중복 확인
                result = false;
//                System.out.println("중복");
//                System.out.println(num+" "+inputArr[i+1]);
                break;
            }

            if (lotto.length != 6) { //숫자 6개 확인
                result = false;
//                System.out.println("6자리");
                break;
            }

            if (num < 1 || num >= 45) { //범위 확인
                result = false;
//                System.out.println("범위");
                break;
            }

            if (num != Integer.parseInt(lotto[i])) { //오름차순 확인
                result = false;
//                System.out.println("오름차순");
                break;
            }
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}
