package July;

import java.util.Scanner;

public class Solution_BJ_1012_¿Ø±‚≥ÛπË√ﬂdfs {
	static int[][] map;
	static boolean[][] v;
	static int res;
	static int[] fx = { 0, 1, 0, -1 };
	static int[] fy = { -1, 0, 1, 0 };
	static int N, M;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			intput();
			pro();
			print();
		}
	}

	public static void intput() {
		N = sc.nextInt();
		M = sc.nextInt();
		int K = sc.nextInt();
		map = new int[N][M];
		v = new boolean[N][M];
		for (int j = 0; j < K; j++) {
			map[sc.nextInt()][sc.nextInt()] = 1;
		}
	}

	public static void pro() {
		res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !v[i][j]) {
					dfs(i, j);
					res++;
				}
			}
		}
		System.out.println(res);
	}

	private static void dfs(int x, int y) {
		v[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + fx[i];
			int ny = y + fy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			if (map[nx][ny] == 0 || v[nx][ny])
				continue;
			dfs(nx, ny);
		}
	}
	
	public static void print()	{
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
