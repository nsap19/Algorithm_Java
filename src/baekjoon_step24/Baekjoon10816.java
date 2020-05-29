/*[이진탐색-상/하한선((lower bound,upper bound)]
이진탐색이 데이터내 특정 값을 정확히 찾는 것이라면
lower bound와 upper bound 는 이진탐색 알고리즘에서 약간 변형된 것으로 중복된 자료가 있을때 유용하게 탐색할 수 있는 알고리즘.
lower bound는 데이터내 특정 K값보다 같거나 큰값이 처음 나오는 위치를 리턴해주고, upper bound 는 K값보다 처음으로 큰 값이 나오는 위치를 리턴해주는 알고리즘이다.

이진탐색과 다른점은 크기가 9인  int test1[] = {1,2,2,3,3,3,4,6,7} 이 주어질때
이진탐색은 정확히 같은 값이 있는곳을 찾는거지만
lower bound는 주어진 값보다 같거나 큰 값이 처음으로 나오는걸 리턴해야 하는데
만약 lower_bound(9) 면 주어진 배열크기(8이 아닌 9) 만큼 리턴되어야 하기 때문에 last = array.length -1 이 아니고 last = array.length로 지정 해야 한다.
* */
package baekjoon_step24;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        long[] arr2 = new long[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            long num = Long.parseLong(st.nextToken());
            bw.write(String.valueOf(upperBound(arr, num) - lowerBound(arr, num)) + " ");
        }
        bw.close();
    }

    private static int lowerBound(long[] arr, long num) {
        //탐색한 값이  주어진 값보다 크거나 같으면 바로 리턴하지 않고, 처음으로 나오는 값을 찾기위해 범위를 더 좁히면서 찾아간다.
        //따라서 크거나 같은경우 last = mid 로 지정해서 범위를 좀더 좁혀 나가면서 찾아가는 것이다.
        int first = 0;
        int last = arr.length;
        int mid = 0;

        while (first < last) {
            mid = (first + last) / 2;

            if (num <= arr[mid]) last = mid;
            else first = mid + 1;
        }

        return first;
    }

    private static int upperBound(long[] arr, long num) {
        //탐색한 값이 주어진 값보다 크다면  바로 리턴하지 않고 최초로 큰 값이 있는 위치를  찾기 위해 last = mid 지정하여 범위를 더 좁히면서 찾아가면 된다.
        int first = 0;
        int last = arr.length;
        int mid = 0;

        while (first < last) {
            mid = (first + last) / 2;
            if (num >= arr[mid]) first = mid + 1;
            else last = mid;
        }

        return first;
    }
}
