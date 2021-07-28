package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_BJ_DFS¿ÍBFS {
	static Scanner scan = new Scanner(System.in);
	static int N,M,V;
	static int[][] adj;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	static void input() {
		N = scan.nextInt();
		M= scan.nextInt();
		V = scan.nextInt();
		adj = new int[N+1][N+1];
		for(int i = 1; i <= M; i++) {
			int x = scan.nextInt() , y = scan.nextInt();
			adj[x][y] = 1;
			adj[y][x] = 1;
		}
	}
	static void pro() {
		visit = new boolean[N+1];
		dfs(V);
		sb.append('\n');
		for(int i = 1; i <= N; i++)visit[i] = false;
		bfs(V);
		System.out.println(sb);
	}
	static void dfs(int x) {
		visit[x] = true;
		sb.append(x).append(' ');
		for(int y = 1; y <= N; y++) {
			if (adj[x][y] == 0)
				continue;
			if(visit[y] == true)
				continue;
			dfs(y);
		}
	}
	static void bfs(int x) {
		Queue<Integer> que = new LinkedList<>();
		
		que.add(x);
		visit[x] = true;
		
		while(!que.isEmpty()) {
			x = que.poll();
			sb.append(x).append(' ');
			for(int y = 1; y <= N; y++) {
				if(adj[x][y]==0)
					continue;
				if(visit[y] == true)
					continue;
				
				que.add(y);
				visit[y] = true;
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		pro();
	}
}
