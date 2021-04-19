package Feb;

import java.util.*;

public class Solution_PG_KAKAO_경주로건설 {
	public static void main(String[] args) {
		int[][] arr = {{0,0,0},{0,0,0},{0,0,0}};
		System.out.println(solution(arr));
	}

	static int min = Integer.MAX_VALUE;
	static int[] xx = { -1, 0, 1, 0 };
	static int[] yy = { 0, -1, 0, 1 };
	static int[][] map;
	static int n;
	static int answer;

	public static int solution(int[][] board) {
		answer = Integer.MAX_VALUE;
		n = board.length;
		map = board;

		// 초기 방향을 -1 을 주는 이유는 자동차가 시작할 때 오른쪽과 아래로 둘 다 이동 가능 하기 때문.
		bfs(0, 0, 0, -1);
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board.length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		return answer;
	}

	public static void bfs(int x, int y, int cost, int dir) {
		Queue<Road> q = new LinkedList<>();
		q.add(new Road(x, y, cost, dir));
		// 출발지점을 1로 바꾸어 탐색에서 제외한다
		map[x][y] = 1;
		while (!q.isEmpty()) {
			Road temp = q.poll();
			// 목적지에 도착했다면 최소 비용을 갱신해준다.
			if (temp.x == n - 1 && temp.y == n - 1) {
				answer = Math.min(answer, temp.cost);
				continue;
			}

			// 4방향으로 이동 할 수 있다.
			for (int i = 0; i < 4; i++) {
				int new_x = temp.x + xx[i];
				int new_y = temp.y + yy[i];
				// 새로 이동하는 곳은 범위 안이고 벽이 아니여야 한다.
				if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < n && map[new_x][new_y] != 1) {
					int new_cost = 0;
					// 새로운 지점의 비용 구하기
					if (temp.dir == -1 || temp.dir == i) {
						new_cost = temp.cost + 100;
					} else if (temp.dir != i) {
						new_cost = temp.cost + 600;
					}

					// 처음가는 곳이라면 정보를 넣어주면 된다.
					if (map[new_x][new_y] == 0) {
						map[new_x][new_y] = new_cost;
						q.add(new Road(new_x, new_y, new_cost, i));
					} else if (map[new_x][new_y] >= new_cost) {
						// 처음가지않는 곳이라면 비용이 더작거나 같은 경우 넣어주면된다.
						map[new_x][new_y] = new_cost;
						q.add(new Road(new_x, new_y, new_cost, i));
					}
				}
			}
		}
	}
}

class Road {
	int x, y, cost, dir;

	public Road(int x, int y, int cost, int dir) {
		this.x = x;
		this.y = y;
		this.cost = cost;
		this.dir = dir;
	}
}
