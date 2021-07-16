package July;

import java.util.*;

public class Solution_BJ_1012_¿Ø±‚≥ÛπË√ﬂbfs {
	
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[][] map;
	static int N, M;
	static boolean[][] v;
	static int[] fx = { 0, 1, 0, -1 };
	static int[] fy = { -1, 0, 1, 0 };
	static Scanner sc = new Scanner(System.in);
	static int res = 0;

	public static void main(String[] args) {
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			input();
			print();
			pro();
		}
	}

	public static void input() {
		int M = sc.nextInt();
		int N = sc.nextInt();
		int K = sc.nextInt();
		map = new int[M][N];
		v = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			map[sc.nextInt()][sc.nextInt()] = 1;
		}
	}

	public static void pro() {
		res = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
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
		q.add(new Point(x, y));
		v[x][y] =true;
		while (!q.isEmpty()) {
			Point tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + fx[i];
				int ny = tmp.y + fy[i];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;
				if (map[nx][ny] == 1 && !v[nx][ny]) {
					q.add(new Point(nx, ny));
					v[nx][ny] = true;
				}
			}
		}
	}
	public static void print()	{
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	
}
