package Apr;

public class Solution_PG_방문길이 {
	public static void main(String[] args) {
		String test = "LULLLLLLU";
		System.out.println(solution(test));
	}
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static boolean[][][][] v;
	static int cnt = 0;
	public static int solution(String dirs) {
        v = new boolean[11][11][11][11];
        dfs(5,5,dirs);
        return cnt;
    }
	
	public static int dfs(int x, int y, String s) {
		int i = 0;
		int fx;
		int fy;
		for(char c : s.toCharArray()) {
			if(c == 'U')
				i = 0;
			else if (c == 'R')
				i = 1;
			else if (c == 'D')
				i = 2;
			else
				i = 3;
			
			fx = x + dx[i];
			fy = y + dy[i];
			if(fx < 0 || fy < 0 || fx > 10 || fy > 10) {
				continue;
			}
			if(!v[fx][fy][x][y] && !v[x][y][fx][fy]) {
				cnt++;
				v[x][y][fx][fy] = true;
				v[fx][fy][x][y] = true;
			}
			x = fx;
			y = fy;
		}
		return cnt;
	}
}
