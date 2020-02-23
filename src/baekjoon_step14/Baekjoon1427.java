package baekjoon_step14;

import java.io.*;

public class Baekjoon1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String n = br.readLine();
        int[] arr = new int[n.length()];
        int temp;

        for (int i = 0; i < n.length(); i++) {
            arr[i] = (int) n.charAt(i);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] <= arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        for (int value : arr) bw.write(value);

        bw.close();


    }
}
