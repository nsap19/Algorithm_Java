package baekjoon_step18;

import java.io.*;

public class Baekjoon1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String st = br.readLine();
        String[] minusArr = st.split("-");
        int result = 0;

        for (int i = 0; i < minusArr.length; i++) {
            String[] plusArr = minusArr[i].split("\\+");
            int sum = 0;

            for (int j = 0; j < plusArr.length; j++) {
                sum += Integer.parseInt(plusArr[j]);
            }

            if (i == 0) result = sum;
            else result -= sum;
        }

        bw.write(String.valueOf(result));
        bw.close();

    }
}
