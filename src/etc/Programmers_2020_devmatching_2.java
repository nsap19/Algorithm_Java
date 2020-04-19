package etc;

public class Programmers_2020_devmatching_2 {
    public static void main(String[] args) {
        int[][] office = {{5,-1,4},{6,3,-1},{2,-1,1}};
        int r =1;
        int c = 0;
        String[] move={"go","go","right","go","right","go","left","go"};
        int result = solution(office, r, c, move);
        System.out.println(result);
    }
    public static int solution(int[][] office, int r, int c, String[] move) {
        int answer = 0;
        String[] news = {"n", "e", "s", "w"};
        int k = 0;
        String dir = news[k];

        answer += office[r][c];
        office[r][c] = 0;

        for (int i = 0; i < move.length; i++) {
            String mv = move[i];
            if (mv == "right") {
                if (k == 3) k = 0;
                else k++;
                dir = news[k];
            } else if (mv == "left") {
                if (k == 0) k = 3;
                else k--;
                dir = news[k];
            } else {
                if (dir == "n" && r > 0 && office[r - 1][c] != -1) r--;
                else if (dir == "e" && c < office.length - 1 && office[r][c + 1] != -1) c++;
                else if (dir == "w" && c > 0 && office[r][c - 1] != -1) c--;
                else if (dir == "s" && r < office.length - 1 && office[r + 1][c] != -1) r++;

                answer += office[r][c];
                office[r][c] = 0;
            }
        }
        return answer;
    }

}
