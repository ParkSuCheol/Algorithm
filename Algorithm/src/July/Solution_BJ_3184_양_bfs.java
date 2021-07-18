package July;

import java.util.*;

public class Solution_BJ_3184_¾ç_bfs {
	static class Point {
		int r;
		int c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static boolean[][] v;
	static char[][] map;
	static int R, C;
	static int sheepResult = 0;
	static int wolfResult = 0;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

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
				if (map[i][j] != '#' && !v[i][j]) {
					bfs(new Point(i, j));
				}
			}
		}
		System.out.println(sheepResult + " " + wolfResult);
	}

	public static void bfs(Point point) {
		Queue<Point> q = new LinkedList<>();
		q.offer(point);
		v[point.r][point.c] = true;
		int wolfCnt = 0;
		int sheepCnt = 0;
		while (!q.isEmpty()) {
			Point tmp = q.poll();
			int r = tmp.r;
			int c = tmp.c;
			if (map[r][c] == 'o')
				sheepCnt++;
			else if (map[r][c] == 'v')
				wolfCnt++;
			for (int i = 0; i < 4; i++) {
				int r2 = tmp.r + dx[i];
				int c2 = tmp.c + dy[i];
				if(r2 >= R || c2 >= C || r2 < 0 || c2 < 0)
					continue;
				if(map[r2][c2] == '#' || v[r2][c2])
					continue;
				v[r2][c2] = true;
				q.offer(new Point(r2,c2));
			}
		}
		if(sheepCnt > wolfCnt)
			sheepResult += sheepCnt;
		else 
			wolfResult += wolfCnt;
	}
}
