package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution_BJ_단지번호붙이기 {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int N, group_cnt;
	static String[] a;
	static boolean[][] visit;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static ArrayList<Integer> group;

	public static void main(String[] args) {
		input();
		pro();
	}

	static void input() {
		N = sc.nextInt();
		a = new String[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.next();
		}
		visit = new boolean[N][N];
	}

	// x,y 를 갈 수 있따는걸 알고 방문한 상태
	static void dfs(int x, int y) {
		// 단지에 속한 집의 개수 증가, visit 체크하기
		group_cnt++;
		visit[x][y] = true;

		// 인접한 집으로 새로운 방문하기
		for (int k = 0; k < 4; k++) {
			// (x,y) ->dir[k]
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			if (a[nx].charAt(ny) == '0')
				continue;
			if (visit[nx][ny])
				continue;
			dfs(nx, ny);
		}
	}

	static void pro() {
		group = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && a[i].charAt(j) == '1') {
					// 갈 수 있는 칸인데, 이미 방문처리 된, 즉 새롭게 만난 단지인 경우!
					group_cnt = 0;
					dfs(i, j);
					group.add(group_cnt);
				}
			}
		}

		Collections.sort(group);
		sb.append(group.size()).append('\n');
		for (int cnt : group)
			sb.append(cnt).append('\n');
		System.out.println(sb);
	}

}
