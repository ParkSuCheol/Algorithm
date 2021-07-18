package July;

import java.util.*;

class Point{
	int x;
	int y;
	Point(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class Solution_BJ_4963_¼¶ÀÇ°³¼ö_bfs {
	static int w, h, res;
	static int[][] map;
	static boolean[][] v;
	static int[] fx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] fy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			input();
			pro();
		}
	}

	public static void input() {
		map = new int[h][w];
		v = new boolean[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				map[i][j] = sc.nextInt();
			}
		}
	}

	public static void pro() {
		res = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] == 1 && !v[i][j]) {
					bfs(i, j);
					res++;
				}
			}
		}
		System.out.println(res);
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		v[x][y] = true;
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			for (int i = 0; i < 8; i++) {
				int nh = tmp.x + fy[i];
				int nw = tmp.y + fx[i];
				if(nh >= h || nw >= w || nh < 0 || nw < 0)
					continue;
				if(map[nh][nw] == 0 || v[nh][nw])
					continue;
				q.add(new Point(nh,nw));
				v[nh][nw] = true;
			}
		}
	}
}
