package graph;

import java.io.*;
import java.util.*;

public class Solution_BJ_2178_�̷�Ž�� {

	static Scanner scan = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static String[] a;
	static int[][] dist;
	static boolean[][] visit;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static ArrayList<Integer> group;

	public static void main(String[] args) {
		input();
		pro();
	}

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		a = new String[N];
		for (int i = 0; i < N; i++)
			a[i] = scan.next();
		visit = new boolean[N][M];
		dist = new int[N][M];
	}

	// x, y �� �� �� �ִٴ� �� �˰� �湮�� ����
	static void bfs(int x, int y) {
		// dist �迭 �ʱ�ȭ
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dist[i][j] = -1;
			}
		}

		// (x, y)�� Q�� �־��ְ�, visit ǥ�ÿ� dist �� �ʱ�ȭ
		Queue<Integer> Q = new LinkedList<>();
		Q.add(x);
		Q.add(y);
		dist[x][y] = 1;
		visit[x][y] = true;

		// BFS ���� ����
		while (!Q.isEmpty()) {
			x = Q.poll();
			y = Q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (a[nx].charAt(ny) == '0')
					continue;
				if (visit[nx][ny])
					continue;
				Q.add(nx);
				Q.add(ny);
				visit[nx][ny] = true;
				dist[nx][ny] = dist[x][y] + 1;

			}
		}
	}

	static void pro() {
		// �������� (0, 0)�� Ž�� ����
		bfs(0,0);

		// (N-1, M-1)���� �ʿ��� �ּ� �̵� Ƚ�� ���
		System.out.println(dist[N-1][M-1]);
	}
}
