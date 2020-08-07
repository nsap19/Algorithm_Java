package etc.programmers_Lv1;

import java.io.*;

public class Programmers_Lv1_22 {
    public static void main(String[] args) throws IOException {
        System.out.println(solve("1S2D*3T")); //37
        System.out.println(solve("1D2S#10S")); //9
        System.out.println(solve("1D2S0T")); //3
        System.out.println(solve("1S*2T*3S")); //23
        System.out.println(solve("1D#2S*3S")); //5
        System.out.println(solve("1T2D3D#")); //-4
        System.out.println(solve("1D2S3T*")); //59

    }

    public static int solve(String dartResult) {
        int[] arr = new int[3];
        int curIdx = 0;
        String tempNum = "";

        for (char c : dartResult.toCharArray()) {
            if (Character.isDigit(c)) {
                tempNum += c;
            } else {
                if (!"".equals(tempNum)) {
                    arr[curIdx++] = Integer.parseInt(tempNum);
                    tempNum = "";
                }

                switch (c) {
                    case 'S':
                        arr[curIdx - 1] = (int) Math.pow(arr[curIdx - 1], 1);
                        break;
                    case 'D':
                        arr[curIdx - 1] = (int) Math.pow(arr[curIdx - 1], 2);
                        break;
                    case 'T':
                        arr[curIdx - 1] = (int) Math.pow(arr[curIdx - 1], 3);
                        break;
                    case '*':
                        arr[curIdx - 1] *= 2;
                        if (curIdx - 2 >= 0) arr[curIdx - 2] *= 2;
                        break;
                    case '#':
                        arr[curIdx - 1] *= -1;
                        break;
                }
            }
        }
        return arr[0] + arr[1] + arr[2];
    }
}
