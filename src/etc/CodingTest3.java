package etc;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class CodingTest3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] banks = br.readLine().split(" ");


        for (int i = 0; i < banks.length; i++) {
            Stack<String> stack = new Stack<>();

            for (int j = 0; j < i + 1; j++) {
                String bankName = banks[j];
                stack.push(bankName);
            }
//            System.out.println(stack.toString());

            Set<String> bankList = new LinkedHashSet<>();
            while (!stack.isEmpty()) {
                if (bankList.size() == 5) {
                    break;
                }
                bankList.add(stack.pop());
            }

            bankList.forEach(v -> {
                System.out.print(v+" ");
            });
            System.out.println();

        }
    }
}

//최근 사용한 순서대로 결제수단을 나열해주십시오.
//
//규칙
//내가 기억할 수 있는 결제수단은 최근 5개의 결제수단이다
//주어진 input은 내가 사용한 순서대로 나열한 것이다.(나열된 값 중 가장 마지막 값이 사용자가 가장 최근에 사용한 결제수단이다.)
//주어진 input을 기준으로 매 결제수단 사용시 최근 5개 결제수단을 출력하시오.
//
//예시1
//입력 - 우리 우리 우리 하나 우리 국민 삼성 농협 농협 농협 국민 저축
//출력 -
//우리
//우리
//우리
//하나 우리
//우리 하나
//국민 우리 하나
//삼성 국민 우리 하나
//농협 삼성 국민 우리 하나
//농협 삼성 국민 우리 하나
//농협 삼성 국민 우리 하나
//국민 농협 삼성 우리 하나
//저축 국민 농협 삼성 우리