package etc;

import java.io.*;

public class CodingTest1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean result = false;

        for (int i = 0; i < input.length() - 1; i++) {
            int num = input.charAt(i) - '0';
            int next = input.charAt(i + 1) - '0';

            if (num == 1) {
                if (input.substring(i+1).contains("1")) {
                    result = false;
                    break;
                } else
                    result = true;

            } else if (num == 2 && next == 1) result = true;
            else if (num == 2 && next == 2) result = true;
            else {
                result = false;
                break;
            }
        }

        System.out.println(result);

    }
}
