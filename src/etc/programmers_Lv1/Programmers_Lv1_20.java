/* [1차] 비밀지도

* 문제 설명
네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다. 그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다. 다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.

    1. 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 공백(" ) 또는벽(#") 두 종류로 이루어져 있다.
    2. 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 지도 1과 지도 2라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
    3. 지도 1과 지도 2는 각각 정수 배열로 암호화되어 있다.
    4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.

* 입력 형식
입력으로 지도의 한 변 크기 n 과 2개의 정수 배열 arr1, arr2가 들어온다.
    - 1 ≦ n ≦ 16
    - arr1, arr2는 길이 n인 정수 배열로 주어진다.
    - 정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2n - 1을 만족한다.
* 출력 형식
원래의 비밀지도를 해독하여 '#', 공백으로 구성된 문자열 배열로 출력하라.
*/
package etc.programmers_Lv1;

import java.io.*;
import java.util.Arrays;

public class Programmers_Lv1_20 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] arr1_s = br.readLine().split(", ");
        String[] arr2_s = br.readLine().split(", ");
        int[] arr1 = Arrays.stream(arr1_s).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(arr2_s).mapToInt(Integer::parseInt).toArray();

        bw.write(Arrays.toString(solution1(n,arr1,arr2))+"\n");
        bw.write(Arrays.toString(solution2(n,arr1,arr2)));
        bw.close();


    }

    //내 풀이
    public static String[] solution1(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String bin = Integer.toBinaryString(arr1[i] | arr2[i]);
            String s = "";

            if (bin.length() < n)
                for (int j = 0; j < n - bin.length(); j++) s += " ";

            for (int j = 0; j < bin.length(); j++) {
                if (bin.charAt(j) == '1') s += "#";
                else s += " ";
            }
            answer[i] = s;
        }

        return answer;
    }

    //다른 사람의 풀이
    public static String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            // %5s => 5칸을 확보해 놓고, 넣고싶은 문자열을 오른쪽 정렬해서 채워넣음(문자열(%s) 포맷 변환) => 0으로 채워넣는게 아닌 공백으로 채워넣는 것
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
    }
}

