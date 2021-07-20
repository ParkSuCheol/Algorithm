package July;

import java.util.*;

public class Solution_BJ_1389_�ɺ�����_dfs_������distȰ�� {
	public static void main(String[] args) {
		input();
		pro();
	}

	// N ������ �� , M ģ�� ������ ��
	// A �� B �� ģ���̸� B �� A �� ģ���̴�
	static int N, M;
	static int[][] map;
	static int[][] v;
	static int min, ans, sum;
	static Scanner sc = new Scanner(System.in);

	public static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][N + 1];
		v = new int[N + 1][N + 1];
		min = 7 * N;
		ans = 0;
		for (int i = 1; i <= M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;
		}
	}

	public static void pro() {
		for (int i = 1; i <= N; i++) {
			bfs(i);
		}
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += v[i][j];
			}
			if(sum < min) {
				min = sum;
				ans = i;
			}
		}
		System.out.println(ans);
	}

	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (map[x][i] == 1) {
				visit[i] = true;
				v[x][i] = 1;
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int y = q.poll();
			for (int i = 1; i <= N; i++) {
				if (map[y][i] == 1 && !visit[i]) {
					q.add(i);
					v[x][i] = v[x][y] + 1;
					visit[i] = true;
				}
			}
		}
	}
}
