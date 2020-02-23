package baekjoon_step14;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Baekjoon1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        String temp_s;

        for (int i = 0; i < n; i++) {
            temp_s = br.readLine();
            if (!arr.contains(temp_s)) arr.add(temp_s);
        }

        Collections.sort(arr);


        for (int i = 1; i <= 50; i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (arr.get(j).length() == i) {
                    temp.add(arr.get(j));
                }
            }
        }

        for (int j = 0; j < temp.size(); j++) {
            bw.write(temp.get(j) + "\n");
        }

        bw.close();
    }
}
