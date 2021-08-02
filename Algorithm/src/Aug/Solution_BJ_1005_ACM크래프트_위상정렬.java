package Aug;
import java.util.*;
public class Solution_BJ_1005_ACM크래프트_위상정렬 {
	public static void main(String[] args) {
		int Q = sc.nextInt();
		while(Q > 0) {
			Q--;
			input();
			pro();
		}
	}

	static int N, M;
	// N 명의 학생들 , 학생들의 키를 M번 비교한다.
	static Scanner sc = new Scanner(System.in);
	static LinkedList<Integer>[] list;
	static StringBuilder sb = new StringBuilder();
	static int[] indeg,T_done,T;
	public static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		list = new LinkedList[N + 1];
		indeg = new int[N+1];
		T = new int[N+1];
		T_done = new int[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<>();
			T[i] = sc.nextInt();
		}
		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			indeg[b]++;
		}
	}

	public static void pro() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0) {
				q.add(i);
				T_done[i] = T[i];
			}
		}
		
		// 정렬 될 수 있는 정점이 있다면
		// 1. 정렬 결과에 추가하기
		// 2. 정점과 연결된 간선 제거하기
		// 3. 새롭게 "정렬 될 수 있는" 정점
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int y : list[x]) {
				indeg[y]--;
				if(indeg[y] == 0)
					q.add(y);
				T_done[y] = Math.max(T_done[y], T_done[x] + T[y]);
			}
		}
		int M = sc.nextInt();
		System.out.println(T_done[M]);
	}
}
