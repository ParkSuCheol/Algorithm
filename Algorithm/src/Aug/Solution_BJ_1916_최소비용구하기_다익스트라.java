package Aug;
import java.util.*;
public class Solution_BJ_1916_�ּҺ�뱸�ϱ�_���ͽ�Ʈ�� {
	static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        public int to, weight;

        public Edge(int _to, int _weight) {
            this.to = _to;
            this.weight = _weight;
        }
    }

    static class Info {
        public int idx, dist;

        public Info() {
        }

        public Info(int _idx, int _dist) {
            this.idx = _idx;
            this.dist = _dist;
        }
    }

    static int N, M, start, end;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        dist = new int[N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<Edge>();
        for (int i = 1; i <= M; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();
            edges[from].add(new Edge(to, weight));
        }
        start = scan.nextInt();
        end = scan.nextInt();
    }

    static void dijkstra(int start) {
        // ��� ���������� ���� �Ÿ��� ���Ѵ�� �ʱ�ȭ ���ֱ�.
        // �����ǻ��ס�
        // ������ �������� ������ �Ÿ��� �ִ񰪺��� ū ������ �����ؾ� �Ѵ�.
        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;

        // �ּ� �� ����
        PriorityQueue<Info> pq = new PriorityQueue<>((o1,o2)->o1.dist-o2.dist);
        //PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        // �ٸ� ���) PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

        // �������� ���� ����(Information)�� ��Ͽ� �߰��ϰ�, �Ÿ� �迭(dist)�� �������ش�.
        pq.add(new Info(start, 0));
        dist[start] = 0;

        // �Ÿ� �������� ��� ������ ������ �Ÿ� ������ �ݺ��Ѵ�.
        while (!pq.isEmpty()) {
            Info info = pq.poll();
            
            // ���� ������ �ֽ� ������ �ٸ���, �ǹ̾��� ���� �����̹Ƿ� ����Ѵ�.
            if (dist[info.idx] != info.dist) continue;

            // ����� ��� �������� ���ؼ� �ٸ� �����鿡 ���� ������ �������ش�.
            for (Edge e : edges[info.idx]) {
                if (dist[info.idx] + e.weight >= dist[e.to]) continue;

                // e.to ���� �� �� �ִ� �� ª�� �Ÿ��� ã�Ҵٸ� �̿� ���� ������ �����ϰ� PQ�� ������ش�.
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    static void pro() {
        dijkstra(start);
        System.out.print(dist[end]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
