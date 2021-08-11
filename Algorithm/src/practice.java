import java.util.*;

class practice {
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
		int dist;

		Info(int _idx, int _dist) {
			this.idx = _idx;
			this.dist = _dist;
		}
	}

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Edge>[] Edges;
	static int[] dist;
	static int N,M;
	static ArrayList<Integer>[] list;
	static int[] indeg;
	public static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		dist = new int[N + 1];
		Edges = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			Edges[i] = new ArrayList<>();
		for (int i = 1; i <= M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			Edges[from].add(new Edge(to, weight));
		}
	}

	public static void pro() {
	}

	public static void djikstra(int start) {
		for (int i = 1; i <= N; i++)
			dist[i] = Integer.MAX_VALUE;

		PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> (o1.dist - o2.dist));

		pq.add(new Info(start, 0));
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