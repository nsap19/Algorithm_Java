package etc;

import java.io.*;

public class Programmers_2020_summercoding_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        long result = solution(n);

        bw.write(String.valueOf(result));
        bw.close();

        //입력 4 - 출력 9
        //입력 11 - 출력 31
    }

    public static long solution(long n) {
        long answer = 0;
        long[] arr = new long[(int) n + 1];
        long count = 1;
        long pow = 3;

        arr[0] = 1;
        arr[1] = pow;
        int i = 2;
        int j = 0;
        while (i <= n) {
            if (arr[j] == pow) {
                pow *= 3;
                arr[i] = pow;
                i++;
                j = 0;
            }
            arr[i] = pow + arr[j];
            i++;
            j++;
        }

//        System.out.print(arr[(int) n - 1]);

        answer = arr[(int) n - 1];
        return answer;
    }
}


