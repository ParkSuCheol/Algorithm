package Aug;

import java.util.*;


public class Solution_17396_백도어_다익스트라 {
	public static void main(String[] args) {
		input();
		pro();
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
		long dist;

		Info(int _idx, long _dist) {
			this.idx = _idx;
			this.dist = _dist;
		}
	}

	static Scanner sc = new Scanner(System.in);
	static int N, M;
	static long[] dist;
	static ArrayList<Edge>[] Edges;
	static boolean[] sight;

	public static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		dist = new long[N];
		Edges = new ArrayList[N];
		sight = new boolean[N];
		for (int i = 0; i < N; i++) {
			Edges[i] = new ArrayList<>();
			int flag = sc.nextInt();
			if (flag == 1)
				sight[i] = true;
			else
				sight[i] = false;
		}
		sight[N-1] = false;
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int dist = sc.nextInt();
			Edges[from].add(new Edge(to, dist));
			Edges[to].add(new Edge(from, dist));
		}
	}

	public static void pro() {
		Djikstra(0);
		if(dist[N-1] == Long.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dist[N - 1]);
	}

	public static void Djikstra(int start) {
		for (int i = 0; i < N; i++) {
			dist[i] = Long.MAX_VALUE;
		}
		dist[start] = 0;
		PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.dist));
		pq.add(new Info(start, 0));
		while (!pq.isEmpty()) {
			Info info = pq.poll();
			if (dist[info.idx] != info.dist)
				continue;
			for (Edge e : Edges[info.idx]) {
				if (dist[info.idx] + e.weight >= dist[e.to])
					continue;
				if (sight[info.idx])
					continue;
				dist[e.to] = dist[info.idx] + e.weight;
				pq.add(new Info(e.to, dist[e.to]));
			}
		}
	}
}
