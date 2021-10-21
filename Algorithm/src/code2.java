import java.util.Arrays;

public class code2 {
	public static void main(String[] args) {
		String[] B = {".##.#","#.#..","#...#","#.##."};
		solution(B);
	}
	public static int[] dx = {0,1,0,-1};
	public static int[]	dy = {-1,0,1,0};
	public static int[][] map;
	public static boolean[][] v;
	public static int N,M;
	public static int[] answer = new int[3];
	public static int chk; 
	public static int[] solution(String[] B) {
		N = B[0].length();
		M = B.length;
		map = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				char tmp = B[j].charAt(i);
				if(tmp == '.')
					map[i][j] = 0;
				else
					map[i][j] = 1;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!v[i][j] && map[i][j] == 1) {
					chk = 0;
					dfs(i,j);
					if(chk == 1) {
						answer[0]++;
					}else if (chk == 2) {
						answer[1]++;
					}else {
						answer[2]++;
					}
				}
			}
		}
		return answer;
    }
	public static void dfs(int x, int y) {
		chk++;
		v[x][y] = true;
		map[x][y] = 3;
		for(int d = 0; d < 4; d++) {
			int fx = x + dx[d];
			int fy = y + dy[d];
			if(fx >= 0 && fx < N && fy >= 0 && fy < M) {
				if(map[fx][fy] == 0)
					continue;
				if(!v[fx][fy]) {
					map[fx][fy] = 3;
					dfs(fx,fy);
				}
			}
		}
	}
}
