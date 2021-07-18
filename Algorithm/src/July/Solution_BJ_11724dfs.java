package July;

import java.util.Scanner;

public class Solution_BJ_11724dfs {
	static Scanner sc = new Scanner(System.in);
	static int N,M;
	static int[][] adj;
	static boolean[] v;
	static int res = 0;
	public static void main(String[] args) {
		input();
		pro();
	}
	static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		adj = new int[N+1][N+1];
		v = new boolean[N+1];
		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a][b] = 1;
			adj[b][a] = 1;
		}
	}
	static void pro() {
		res = 0;
		for(int i = 1; i<= N; i++) {
			if(!v[i]) {
				dfs(i);
				res++;
			}
		}
		System.out.println(res);
	}
	
	static void dfs(int start) {
		v[start] = true;
		for(int i = 1; i <= N; i++) {
			if(adj[start][i] == 1 && !v[i])
				dfs(i);
		}
	}
}
