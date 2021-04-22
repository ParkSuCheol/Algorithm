
import java.util.*;

class practice {
	public static void main(String[] args) {
		int[][] ar = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } };
		System.out.println(solution(ar));
	}

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static boolean[][] v;
	static int N, M;

	public static int solution(int[][] maps) {
		N = maps.length;
		M = maps[0].length;
		v = new boolean[N][M];
		return bfs(0, 0, maps);
	}

	public static int bfs(int x, int y, int[][] map) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y, 1));
		v[x][y] = true;
		while (!q.isEmpty()) {
			Point temp = q.poll();
			if (temp.x == N - 1 && temp.y == M - 1) {
				return temp.cost;
			}
			for (int i = 0; i < 4; i++) {
				int fx = temp.x + dx[i];
				int fy = temp.y + dy[i];
				if (fx < 0 || fy < 0 || fx >= N || fy >= M)
					continue;
				if (!v[fx][fy] && map[fx][fy] == 1) {
					v[fx][fy] = true;
					q.add(new Point(fx, fy, temp.cost + 1));
				}
			}
		}
		return -1;
	}

	static class Point {
		int x;
		int y;
		int cost;

		Point(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}
