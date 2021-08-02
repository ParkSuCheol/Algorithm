package graph;

import java.util.*;

public class Solution_BJ_3055_Ż�� {
	static Scanner scan = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static String[] a;
	static int[][] dist_water, dist_hedgehog;
	static boolean[][] visit;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static ArrayList<Integer> group;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		a = new String[N];
		for (int i = 0; i < N; i++)
			a[i] = scan.next();
		visit = new boolean[N][M];
		dist_water = new int[N][M];
		dist_hedgehog = new int[N][M];
	}

	// ��� ������ �������� ���ÿ� BFS ����!
	static void bfs_water() {
		Queue<Integer> Q = new LinkedList<>();
		// ��� ���� ��ġ�� Q�� ���� �־��ֱ�!
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// dist_water �� visit �迭 �ʱ�ȭ
				dist_water[i][j] = -1;
				visit[i][j] = false;
				if (a[i].charAt(j) == '*') {
					Q.add(i);
					Q.add(j);
					dist_water[i][j] = 0;
					visit[i][j] = true;
				}
			}
		}

		// BFS ���� ����
		while(!Q.isEmpty()) {
			int x = Q.poll();
			int y = Q.poll();
			for(int k = 0; k < 4; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if(a[nx].charAt(ny) != '.')
					continue;
				if(visit[nx][ny])
					continue;
				visit[nx][ny] = true;
				dist_water[nx][ny] = dist_water[x][y] + 1;
				Q.add(nx);
				Q.add(ny);
			}
		}
	}

	// ����ġ�� �������� ���ÿ� BFS ����!
	static void bfs_hedgehog() {
		Queue<Integer> Q = new LinkedList<>();
		// ����ġ ��ġ�� Q�� �־��ֱ�!
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// dist_hedgehog �� visit �迭 �ʱ�ȭ
				/* TODO */
				if (a[i].charAt(j) == 'S') {
					/* TODO */
				}
			}
		}

		// BFS ���� ����
		/* TODO */
	}

	static void pro() {
		// �� ĭ���� ���� ��� �ð� ����ϱ�
		bfs_water();

		// ����ġ�� ���� ���� Ž���� �� �ִ� ���� ã��
		bfs_hedgehog();

		// Ż�ⱸ 'D' �� ���� ����� ���� ���� ����ϱ�
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (a[i].charAt(j) == 'D') {
					if(dist_hedgehog[i][j] == -1) {
						
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		input();
		pro();
	}

}
