import java.util.*;
class practice{
	static class Point{
		int r; int c;
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int R,C;
	static int sheepResult, wolfResult;
	static char[][] map;
	static boolean[][] v;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	public static void main(String[] args) {
		input();
		pro();
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		v = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
	}
	
	public static void pro() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != '#' && !v[i][j])
					bfs(new Point(i,j));
			}
		}
		System.out.println(sheepResult + " " + wolfResult);
	}
	
	public static void bfs(Point point) {
		Queue<Point> q = new LinkedList<>();
		q.add(point);
		int sheepCnt = 0;
		int wolfCnt = 0;
		v[point.r][point.c] = true;
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			int r = tmp.r;
			int c = tmp.c;
			if(map[r][c] == 'o')
				sheepCnt++;
			else if (map[r][c] == 'v')
				wolfCnt++;
			for (int i = 0; i < 4; i++) {
				int r2 = r + dx[i];
				int c2 = c + dy[i];
				if(r2 >= R || c2 >= C || r2 < 0 || c2 < 0)
					continue;
				if(map[r2][c2] == '#' || v[r2][c2])
					continue;
				q.add(new Point(r2,c2));
				v[r2][c2] = true;
			}
		}
		if(sheepCnt > wolfCnt)
			sheepResult += sheepCnt;
		else
			wolfResult += wolfCnt;
	}
}