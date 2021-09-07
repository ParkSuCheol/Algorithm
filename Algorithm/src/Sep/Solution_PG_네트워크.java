package Sep;

import java.util.*;

public class Solution_PG_네트워크 {
	public static void main(String[] args) {

	}
	static int[] visited;
	static int nodecount = 0;
	// n : node 수
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new int[n];
		Arrays.fill(visited, 0);
		// 1. bfs 큐 사용해서 처음부터 끝까지 돌면서 - 방문하지 않은 노드 일 경우 count 숫자 증가
		for (int i = 0; i < n; i++) {
			// 처음 친구랑 연결된 모든친구 nodecount 로 동일 처리
			if (visited[i] == 0) {
				nodecount++;
				visited[i] = nodecount;
				bfs(i, computers);
			}
		}
		answer = nodecount;
		return answer;
	}
	private static void bfs(int r, int[][] computers) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(r); // 시작점
		while (!queue.isEmpty()) {
			// 꺼내고
			int cur = queue.poll();
			// 연결된 노드 탐색 - 방문한적 없는
			for (int i = 0; i < computers[cur].length; i++) {
				if (computers[cur][i] == 1 && visited[i] == 0) {
					visited[i] = nodecount;
					queue.add(i); // 큐에 넣자.
				}
			}
		}
	}
}
