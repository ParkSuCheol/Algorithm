package Sep;

import java.util.*;

public class Solution_PG_가장먼노드 {
	public static void main(String[] args) {
		int[][] s = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		System.out.println(solution(6,s));
	}

	public static int solution(int n, int[][] edge) {
		int answer = 0;
		int N = edge.length;
		LinkedList<Integer>[] list = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new LinkedList<>();
		}
		for (int i = 0; i < edge.length; i++) {
			int a = edge[i][0];
			int b = edge[i][1];
			list[a].add(b);
			list[b].add(a);
		}
		int[] count = new int[n + 1];
		boolean[] v = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		v[0] = true;
		v[1] = true;
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int y : list[x]) {
				if (!v[y]) {
					count[y] = count[x] + 1;
					v[y] = true;
					q.add(y);
				}
			}
		}
		
		int max = 0;
		for (int cnt : count) {
			if (max < cnt) {
				max = cnt;
				answer = 1;
			} else if (max == cnt)
				answer++;
		}
		return answer;
	}
}
