/* 첫번째 오답 - 출력 초과
    BufferedWriter 는 내부에 버퍼를 가지고 있으며, 버퍼에 어느 정도 데이터가 차면 비정기적으로 flush 를 실행합니다.
    n이 작은 데이터일 때 NO 를 출력해야 할 때는 flush 를 하기 전에 NO만 출력하고 프로그램이 종료되지만
    n이 충분히 큰 데이터일 때 NO를 출력해야 할 때는 NO를 출력하기 전에 flush 가 발생해서 출력 스트림에 뭔가를 출력해 버립니다.
 => bufferedwriter 대신 string에 += "문자열" 해주는 형식으로 바꿈
*/

/* 두번째 오답 - 메모리 초과
    String에 +=을 하는 건 기존 String의 내용에 뒤의 String의 내용을 이어붙인 새로운 문자열을 만들어서 담고,
    원래의 문자열은 더 참조하는 레퍼런스가 없으면 GC에 들어가게 됩니다.
    이 버려진 문자열이 정확히 언제 메모리에서 완전히 해제되는지는 모르겠지만, 그 전까지는 계속 메모리상에 누적되어 큰 용량을 차지하는 것으로 보입니다.
    또한 이는 시간복잡도 역시 O(N^2)으로 만들기 때문에 적절치 못합니다. 문자열을 길게 계속 이어붙이려면 StringBuilder를 사용해야 합니다.
 => string에 += 하는 대신 StringBuilder를 사용 => 정답 처리
 */
package baekjoon_step20;

import java.io.*;
import java.util.Stack;

public class Baekjoon1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int x = 0;

        for (int i = 1; i <= n; i++) {
            stack.push(i);
//            bw.write("+\n");
            sb.append("+\n");
            while (stack.peek() == arr[x]) {
                stack.pop();
//                bw.write("-\n");
                sb.append("-\n");
                x++;
                if (stack.size() == 0) break;
            }
            if (i == n && x != n) {
                System.out.println("NO");
            } else if (i == n && x == n) {
//                bw.close();
                System.out.println(sb.toString());
            }
        }
    }
}
