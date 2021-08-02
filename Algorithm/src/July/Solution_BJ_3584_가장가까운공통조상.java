package July;

import java.util.*;
import java.io.*;

public class Solution_BJ_3584_가장가까운공통조상 {
	static int N;
	static LinkedList<Integer>[] adj;
	static int[] parent;
	static int[] depth;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int T = 0; T < tc; T++) {
			N = Integer.parseInt(br.readLine());
			adj = new LinkedList[N + 1];
			depth = new int[N + 1];
			parent = new int[N + 1];
			v = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				adj[i] = new LinkedList<>();
			}
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				v[b] = true;
				adj[a].add(b);
			}
			int root = 0;
			for (int i = 1; i <= N; i++) {
				if (!v[i]) {
					root = i;
					break;
				}
			}
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			make_tree(root);
			System.out.println(lca(v1,v2));
		}
	}

	public static void make_tree(int root) {
		Queue<Integer> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int child : adj[temp]) {
				if (parent[child] != 0)
					continue;
				parent[child] = temp;
				depth[child] = depth[temp] + 1;
				q.add(child);
			}
		}
	}

	public static int lca(int a, int b) {
		while (true) {
			if (a == b)
				return a;
			if (depth[a] == depth[b]) {
				while (a != b) {
					a = parent[a];
					b = parent[b];
				}
			} else if (depth[a] < depth[b]) {
				while (depth[a] < depth[b]) {
					b = parent[b];
				}
			} else {
				while (depth[a] > depth[b]) {
					a = parent[a];
				}
			}
		}
	}
}
