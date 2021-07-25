package etc.programmers_Lv2;

//모든 경우의 수를 체크해야하기때문에 DFS를 사용해야겠다고 생각
// - DFS : 모든 노드를 방문하고자 하는 경우에 이 방법을 선택함
// - BFS : 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 이 방법을 선택함
// ex) 지구 상에 존재하는 모든 친구 관계를 그래프로 표현한 후 Ash 와 Vanessa 사이에 존재하는 경로를 찾는 경우
public class Programmers_Lv2_15 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer += dfs(numbers[0], 0, numbers, target);
        answer += dfs(-1 * numbers[0], 0, numbers, target);
        return answer;
    }

    static int dfs(int num, int depth, int[] numbers, int target){
        if(depth==numbers.length-1){
            if(num == target) return 1;
            else return 0;
        }

        int result = 0;
        result += dfs(num+numbers[depth+1], depth+1, numbers, target);
        result += dfs(num-numbers[depth+1], depth+1, numbers, target);

        return result;
    }
}
