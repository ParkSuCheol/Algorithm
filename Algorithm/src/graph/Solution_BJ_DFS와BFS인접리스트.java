package graph;

import java.util.*;

public class Solution_BJ_DFS와BFS인접리스트 {
	static Scanner scan = new Scanner(System.in);
	static int N, M, V;
	static ArrayList<Integer>[] adj;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		V = scan.nextInt();
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= M; i++) {
			int x = scan.nextInt(), y = scan.nextInt();
			adj[x].add(y);
			adj[y].add(x);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(adj[i]);
		}
	}

	static void pro() {
		visit = new boolean[N + 1];
		dfs(V);
		sb.append('\n');
		for (int i = 1; i <= N; i++)
			visit[i] = false;
		bfs(V);
		System.out.println(sb);
	}

	static void dfs(int x) {
		visit[x] = true;
		sb.append(x).append(' ');
		for (int y : adj[x]) {
			if (visit[y])
				continue;
			dfs(y);
		}
	}

	static void bfs(int x) {
		Queue<Integer> que = new LinkedList<>();

		que.add(x);
		visit[x] = true;

		while (!que.isEmpty()) {
			x = que.poll();
			sb.append(x).append(' ');
			for (int y : adj[x]) {
				if (visit[y] == true)
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
