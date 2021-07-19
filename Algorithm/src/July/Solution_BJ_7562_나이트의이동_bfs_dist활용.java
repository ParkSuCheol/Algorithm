package July;

import java.util.*;

public class Solution_BJ_7562_나이트의이동_bfs_dist활용 {
	public static void main(String[] args) {
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			input();
			pro();
		}
	}

	static Scanner sc = new Scanner(System.in);
	static int l, x, y, Gx, Gy;
	static boolean[][] v;
	static int[][] dist;
	static int[] dx = {1,2,2,1,-1,-2,-2,-1};
	static int[] dy = {-2,-1,1,2,2,1,-1,-2};
	public static void input() {
		l = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		Gx = sc.nextInt();
		Gy = sc.nextInt();
		dist = new int[l][l];
		v = new boolean[l][l];
	}
	public static void pro() {
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				dist[i][j] = -1;
			}
		}
		bfs(x,y);
		System.out.println(dist[Gx][Gy] - 1);
	}
	public static void bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		q.add(y);
		dist[x][y] = 1;
		v[x][y] = true;
		while(!q.isEmpty()) {
			int x1 = q.poll();
			int y1 = q.poll();
			for (int i = 0; i < 8; i++) {
				int fx = x1 + dx[i];
				int fy = y1 + dy[i];
				if(fx <0 || fy < 0 || fx >= l || fy >= l)
					continue;
				if(v[fx][fy])
					continue;
				q.add(fx);
				q.add(fy);
				v[fx][fy] = true;
				dist[fx][fy] = dist[x1][y1] + 1;
			}
		}
	}
}
