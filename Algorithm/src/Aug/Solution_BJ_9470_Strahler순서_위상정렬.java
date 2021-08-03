package Aug;
import java.util.*;
public class Solution_BJ_9470_Strahler순서_위상정렬 {
	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			input();
			pro();
		}
	}
	static Scanner sc = new Scanner(System.in);
	static int K,N,M;
	static ArrayList<Integer>[] adj;
	static int[] indeg, order, maxCnt;
	public static void input() {
		K = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		adj = new ArrayList[N+1];
		indeg = new int[N+1];
		order = new int[N+1];
		maxCnt = new int[N+1];
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt(), y = sc.nextInt();
			adj[x].add(y);
			indeg[y]++;
		}
	}
	public static void pro() {
		Queue<Integer> q = new LinkedList<>();
		// 제일 앞에 " 정렬 될 수 있는 " 정점 찾기
		for(int i = 1; i <= N; i++) {
			if(indeg[i] == 0) {
				q.add(i);
				order[i] = maxCnt[i] = 1;
			}
		}
		// Strahler 순서를 고려해서 위상정렬을 수행하자.
		
		// 정렬 될 수 있는 정점이 있다면?
		// 1. 정렬 결과에 추가하기
		// 2. 정점과 연결된 간선 제거하기
		// 3. 새롭게 " 정렬 될 수 있는" 정점 q 에 추가하기
		int ans = 0;
		while(!q.isEmpty()) {
			int x = q.poll();
			// 만약 들어오는 순서 중 가장 큰 순서가 2개 이상이면 자신의 순서를 1 증가시킨다
			if(maxCnt[x] >= 2) order[x]++;
			ans = Math.max(ans, order[x]);
			for(int y:adj[x]) {
				indeg[y]--;
				if(indeg[y] == 0) q.add(y);
				// Stahler 순서 계산을 위해서 y번 정점에 들어오는 최대 순서를 갱신해준다
				if(order[y] == order[x]) maxCnt[y]++;
				else if (order[y] < order[x]) {
					order[y] = order[x];
					maxCnt[y] = 1;
				}
			}
		}
		System.out.println(K + " " + ans);
	}
}
