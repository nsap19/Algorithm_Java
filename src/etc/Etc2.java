package etc;

import java.lang.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Etc2 {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        String text = scanner.nextLine().trim(); // 수정 전 논문의 내용
        String text = "Deeper neural networks are more difficult to train. We present a residual learning framework to ease the training of networks that are substantially deeper than those used previously.[ some_paper_a, some_paper_b ] We explicitly reformulate the layers as learning residual functions with reference to the layer inputs, instead of learning unreferenced functions.[ some_book_a, some_paper_a ] We provide comprehensive empirical evidence showing that these residual networks are easier to optimize, and can gain accuracy from considerably increased depth. [ some_book_b ]";
        int len = text.length(); // 논문의 글자 수
        ArrayList<String> arr = new ArrayList<>();
        int idx = 0;

        Pattern pattern = Pattern.compile("[\\[][\\s](.*?)[\\s][\\]]");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
//            System.out.println(matcher.group(1));
            String[] temp = matcher.group(1).split(", ");
            int[] index = new int[temp.length];
            String s = "";

            for (int i = 0; i < temp.length; i++) {
                if (!arr.contains(temp[i])) arr.add(temp[i]);
                index[i] = arr.indexOf(temp[i]);
            }

            Arrays.sort(index); //[] 내에서의 인덱스 번호 정렬

            //정렬된 순으로 참조 문헌 번호 replace
            for (int i = 0; i < index.length; i++) {
                s += index[i] + 1;
                if (i < index.length - 1) s += ", ";
            }
            text = text.replaceAll(matcher.group(1), s);

            if (matcher.group(1) == null) break;
        }

        System.out.println(text);

        for (int i = 0; i < arr.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + arr.get(i));
        }
    }
}
