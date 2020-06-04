package baekjoon_step24;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(0);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            int value = Integer.parseInt(st.nextToken());

            if (list.get(list.size() - 1) < value) list.add(value);
            else {
                int left = 0;
                int right = list.size() - 1;

                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (list.get(mid) >= value) {
                        right = mid - 1;
                    } else left = mid + 1;
                }
                list.set(left, value);
            }

//            for (int j = 0; j < list.size(); j++) {
//                System.out.print(list.get(j)+" ");
//            }
//            System.out.println();
        }
        bw.write(String.valueOf(list.size() - 1));
        bw.close();
    }
}
