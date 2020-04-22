package baekjoon_step19;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> clothes = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();

                if (clothes.containsKey(kind)) {
                    clothes.put(kind, clothes.get(kind) + 1);
                } else clothes.put(kind, 1);
            }

            int result = 1;
            for (int val : clothes.values()) {
                result *= val + 1;
            }
            result--;
            bw.write(String.valueOf(result) + "\n");
        }

        bw.close();
    }
}
