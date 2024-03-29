package graph;

import java.util.*;

public class Solution_BJ_14502_연구소 {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	static int N, M, B, ans;
	static int[][] A, blank;
	static boolean[][] visit;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		input();
		pro();
	}

	static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		A = new int[N + 1][M + 1];
		blank = new int[N * M + 1][2];
		visit = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++)
				A[i][j] = sc.nextInt();
	}

	static void bfs() {
		Queue<Integer> Q = new LinkedList<>();

		// 모든 바이러스가 시작점으로 가능하니까, 전부 큐에 넣어준다.
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				visit[i][j] = false;
				if (A[i][j] == 2) {
					Q.add(i);
					Q.add(j);
					visit[i][j] = true;
				}
			}
		}
		// BFS 과정
		while (!Q.isEmpty()) {
			int x = Q.poll();
			int y = Q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = x + dir[k][0], ny = y + dir[k][1];
				if (nx < 1 || ny < 1 || nx > N || ny > M)
					continue;
				if (A[nx][ny] != 0)
					continue;
				if (visit[nx][ny])
					continue;
				visit[nx][ny] = true;
				Q.add(nx);
				Q.add(ny);
			}
		}
		// 탐색이 종료된 시점이니, 안전 영역의 넓이를 계산하고, 정답을 갱신한다.
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (A[i][j] == 0 && !visit[i][j])
					cnt++;
			}
		}
		ans = Math.max(ans, cnt);
	}

	static void dfs(int idx, int selected_cnt) {
		if (selected_cnt == 3) { // 3 개의 벽을 모두 세운 상태
			bfs();
			return;
		}
		if (idx > B)
			return; // 더 이상 세울 수 있는 벽이 없는 상태

		A[blank[idx][0]][blank[idx][1]] = 1;
		dfs(idx + 1, selected_cnt + 1);

		A[blank[idx][0]][blank[idx][1]] = 0;
		dfs(idx + 1, selected_cnt);

	}

	static void pro() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (A[i][j] == 0) {
					B++;
					blank[B][0] = i;
					blank[B][1] = j;
				}
			}
		}
		// 벽을 3개 세우는 모든 방법을 확인해보자!
		dfs(1,0);
		System.out.println(ans);
	}
}
