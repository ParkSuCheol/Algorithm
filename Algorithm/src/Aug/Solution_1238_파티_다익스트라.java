package Aug;

import java.util.*;

public class Solution_1238_파티_다익스트라 {
	public static void main(String[] args) {
		input();
	}

	static class Edge {
		int to;
		int weight;

		Edge(int _to, int _weight) {
			this.to = _to;
			this.weight = _weight;
		}
	}

	static class Info {
		int idx;
		int dist;

		Info(int _idx, int _dist) {
			this.idx = _idx;
			this.dist = _dist;
		}
	}

	static Scanner sc = new Scanner(System.in);
	static int N, M, X;

	public static void input() {
		int[] dist, reverse_dist;
		ArrayList<Edge>[] Edges, reverse_Edges;
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();
		dist = new int[N + 1];
		reverse_dist = new int[N + 1];
		Edges = new ArrayList[N + 1];
		reverse_Edges = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			Edges[i] = new ArrayList<>();
			reverse_Edges[i] = new ArrayList<>();
		}
		for (int i = 1; i <= M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			Edges[from].add(new Edge(to, weight));
			reverse_Edges[to].add(new Edge(from, weight));
		}
		Djikstra(X,Edges,dist);
		Djikstra(X,reverse_Edges,reverse_dist);
		int res = 0;
		for (int i = 1; i <= N; i++) {
			int sum = dist[i] + reverse_dist[i];
			if(sum > res)
				res = sum;
		}
		System.out.println(res);
	}

	public static void Djikstra(int start, ArrayList<Edge>[] Edges,int[] dist) {
		for (int i = 1; i <= N; i++) 
			dist[i] = Integer.MAX_VALUE;
		dist[start] = 0;
		
		PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> (o1.dist - o2.dist));
		pq.add(new Info(start, 0));
		while (!pq.isEmpty()) {
			Info info = pq.poll();
			if (dist[info.idx] != info.dist)
				continue;
			for (Edge e : Edges[info.idx]) {
				if (dist[info.idx] + e.weight >= dist[e.to])
					continue;
				dist[e.to] = dist[info.idx] + e.weight;
				
				pq.add(new Info(e.to, dist[e.to]));
			}
		}
	}
}
