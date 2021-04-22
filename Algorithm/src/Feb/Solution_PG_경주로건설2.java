package Feb;

import java.util.*;

class Solution_PG_���ַΰǼ�2 {

	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		System.out.println(solution(arr));
	}

	public static int n;
	public static int[][] map;
	public static boolean[][] visit;

	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };

	public static int cost = Integer.MAX_VALUE;

	public static int solution(int[][] board) {
		int answer = 0;
		// �ڵ��� ���ַ� �Ǽ�
		// nn
		// 0 : �������, 1 : ��
		// �����¿�
		// ���� �ִ�ĭ x
		// ������Ʈ : 100 ��
		// �ڳ� : 500 ��
		// �ּ� ��� : bfs

		// ����
		// �� : 0
		// �� : 1
		// �� : 2
		// �� : 3

		n = board.length;
		map = board;
		visit = new boolean[n][n];

		bfs(0, 0, -1, 0);
		answer = cost;
		return answer;
	}

	public static void bfs(int x, int y, int dir, int price) {
		Queue<Road> q = new LinkedList<>();
		q.add(new Road(x, y, dir, price));
		visit[x][y] = true;

		while (!q.isEmpty()) {
			Road road = q.poll();

			int qx = road.x;
			int qy = road.y;
			int qDir = road.dir;
			int qPrice = road.cost;

			if (qx == n - 1 && qy == n - 1) {
				cost = Math.min(cost, qPrice);
			}

			for (int i = 0; i < 4; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];
				int nDir = i;
				int nPrice = qPrice;

				if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == 1)
					continue;

				if (qDir == -1) {
					nPrice += 100;
				} else if (qDir == nDir) {
					nPrice += 100;
				} else {
					nPrice += 600;
				}

				if (!visit[nx][ny] || map[nx][ny] >= nPrice) {
					visit[nx][ny] = true;
					map[nx][ny] = nPrice;
					q.add(new Road(nx, ny, nDir, nPrice));
				}
			}
		}
	}

	static class Road {
		int x, y, dir, cost;

		Road(int x, int y, int dir, int cost) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cost = cost;
		}
	}
}