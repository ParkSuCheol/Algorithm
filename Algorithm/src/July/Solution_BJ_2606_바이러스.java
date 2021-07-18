package July;
import java.util.*;

public class Solution_BJ_2606_바이러스 {
	static int[][] adj;
	static boolean[] v;
	static int R,C,res;
	public static void main(String[] args) {
		input();
		pro();
	}
	public static void input() {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		adj = new int[R+1][R+1];
		v = new boolean[R+1];
		for (int i = 0; i < C; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a][b] = 1;
			adj[b][a] = 1;
		}
	}
	public static void pro() {
		v[1] = true;
		dfs(1);
		System.out.println(res);
	}
	private static void dfs(int start) {
		v[start] = true;
		for (int i = 2; i <= R; i++) {
			if(!v[i] && adj[start][i] ==1) {
				dfs(i);
				res++;
			}
		}
	}
}
