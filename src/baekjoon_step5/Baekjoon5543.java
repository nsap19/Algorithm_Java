package baekjoon_step5;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] burger = new int[3];
        int[] drink = new int[2];
        int result = 0;
        int temp = 2000;

        for (int i = 0; i < burger.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            burger[i] = Integer.parseInt(st.nextToken());
            if (temp >= burger[i]) temp = burger[i];
        }
        result += temp;

        temp = 2000;
        for (int i = 0; i < drink.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            drink[i] = Integer.parseInt(st.nextToken());
            if (temp >= drink[i]) temp = drink[i];
        }
        result += temp;

        bw.write(String.valueOf(result - 50));
        bw.close();


    }
}
