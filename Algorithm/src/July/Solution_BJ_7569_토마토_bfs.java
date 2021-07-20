package July;

import java.util.*;

public class Solution_BJ_7569_토마토_bfs {
	public static void main(String[] args) {
		input();
		pro();
	}

	// 가로 M , 세로 N , 위로 H
	// 가장 밑에 상자부터 위의 상자까지 토마토들의 정보가 주어짐
	// N 번 만큼 M 개의 정수로 주어진다.
	// 1은 익은 토마토 0은 익지 않은 토마토 -1은 비어있는 칸
	// 토마토는 상,하,좌,우,앞,뒤 만큼
	static int M, N, H, Day = 0;
	static int[][][] map;
	static int[][][] dist;
	static boolean[][][] v;
	static int[] dx = { 0, 1, 0, -1, 0, 0 };
	static int[] dy = { -1, 0, 1, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static Queue<Integer> q = new LinkedList<>();

	public static void input() {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][N][M];
		dist = new int[H][N][M];
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[k][i][j] = sc.nextInt();
					if (map[k][i][j] == 1) {
						q.add(k);
						q.add(i);
						q.add(j);
					}
				}
			}
		}
	}

	public static void pro() {
		bfs();
		int ans = 0;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (ans < dist[k][i][j])
						ans = dist[k][i][j];
				}
			}
		}
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[k][i][j] == 0 && dist[k][i][j] == 0)
						ans = -1;
				}
			}
		}

//		for (int k = 0; k < H; k++) {
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(dist[k][i][j] + " ");
//				}
//				System.out.println();
//			}
//		}

		System.out.println(ans);
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			int z1 = q.poll();
			int y1 = q.poll();
			int x1 = q.poll();
			boolean chk = false;
			for (int i = 0; i < 6; i++) {
				int z2 = z1 + dz[i];
				int y2 = y1 + dy[i];
				int x2 = x1 + dx[i];
				if (z2 < 0 || y2 < 0 || x2 < 0 || z2 >= H || y2 >= N || x2 >= M)
					continue;
				if (dist[z2][y2][x2] == 0 && map[z2][y2][x2] == 0) {
					dist[z2][y2][x2] = dist[z1][y1][x1] + 1;
					q.add(z2);
					q.add(y2);
					q.add(x2);
				}
			}
		}
	}

}
