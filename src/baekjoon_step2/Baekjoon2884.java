package baekjoon_step2;

import java.util.*;

public class Baekjoon2884 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);

        int h = input.nextInt();
        int m = input.nextInt();

        int result_h, result_m;

        if (m < 45)// 0~44분
        {
            result_m = m - 45 + 60;
            if (h - 1 < 0)// h-1이 음수일때(0시)
                result_h = h - 1 + 24;
            else
                result_h = h - 1;
        }
        else// 45~59분
        {
            result_m = m - 45;
            result_h = h;
        }

        System.out.printf("%d %d", result_h, result_m);
    }

}
