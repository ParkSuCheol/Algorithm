package July;

import java.util.*;

public class Solution_BJ_4963_¼¶ÀÇ°³¼ö_dfs {
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
					dfs(i, j);
					res++;
				}
			}
		}
		System.out.println(res);
	}

	public static void dfs(int x, int y) {
		v[x][y] = true;
		for (int i = 0; i < 8; i++) {
			int nh = x + fy[i];
			int nw = y + fx[i];
			if (nh >= h || nw >= w || nh < 0 || nw < 0)
				continue;
			if (map[nh][nw] == 0 || v[nh][nw])
				continue;
			v[nh][nw] = true;
			dfs(nh, nw);
		}
	}
}
