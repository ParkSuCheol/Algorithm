package July;
import java.util.*;
public class Solution_BJ_18404_현명한나이트_bfs_dist활용 {
	public static void main(String[] args) {
		input();
		pro();
	}
	static int[][] dist;
	static boolean[][] v;
	static int[] dx = {1,2,2,1,-1,-2,-2,-1};
	static int[] dy = {-2,-1,1,2,2,1,-1,-2};
	static int N,M,X,Y;
	static Scanner sc = new Scanner(System.in);
	public static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();
		Y = sc.nextInt();
		dist = new int[N+1][N+1];
		v = new boolean[N+1][N+1];
	}
	public static void pro() {
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				dist[i][j] = -1;
			}
		}
		bfs(X,Y);
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(dist[a][b] - 1);
		}
	}
	public static void bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<>();
		dist[x][y] = 1;
		v[x][y] = true;
		q.add(x);
		q.add(y);
		while(!q.isEmpty()) {
			int x2 = q.poll();
			int y2 = q.poll();
			for (int i = 0; i < 8; i++) {
				int fx = x2 + dx[i];
				int fy = y2 + dy[i];
				if(fx < 1 || fy < 1 || fx >= N+1 || fy >= N+1)
					continue;
				if(v[fx][fy])
					continue;
				q.add(fx);
				q.add(fy);
				dist[fx][fy] = dist[x2][y2] + 1;
				v[fx][fy] = true;
			}
		}
	}
}
