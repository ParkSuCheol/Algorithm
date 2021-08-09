package Aug;

import java.util.*;

public class Solution_BJ_1446_Áö¸§±æ {
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
	static int N, D;
	static ArrayList<Edge>[] Edges;
	static int[] dist;

	public static void input() {
		N = sc.nextInt();
		D = sc.nextInt();
		dist = new int[10001];
		Edges = new ArrayList[10001];
		for (int i = 0; i < N; i++) {
			Edges[i] = new ArrayList<>();
			dist[i] = i;
		}
		for (int i = 0; i < N; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int dist = sc.nextInt();
			Edges[i].add(new Edge(to, dist));
		}
	}

	public static void pro() {
		Djikstra(0);
		System.out.println(Arrays.toString(dist));
	}

	public static void Djikstra(int start) {
		PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> (o1.dist - o2.dist));
		pq.add(new Info(start, 0));
		for (int i = 0; i < N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;
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
