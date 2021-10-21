
public class KAKAO_6 {
	public static void main(String[] args) {
		
	}
	public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        for (int i = 0; i < skill.length; i++) {
			dfs(board,skill[i]);
		}
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j] >= 1)
					answer++;
			}
        }
        return answer;
    }
	public static void dfs(int[][] board, int[] skill) {
		int type = skill[0];
		int r1 = skill[1];
		int c1 = skill[2];
		int r2 = skill[3];
		int c2 = skill[4];
		int degree = skill[5];
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				if(type == 1) {
					board[i][j] -= degree;
				}else
					board[i][j] += degree;
			}
		}
	}
}
