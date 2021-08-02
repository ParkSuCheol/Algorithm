package Aug;

import java.util.*;

public class Solution_BJ_2252_줄세우기_위상정렬 {
	public static void main(String[] args) {
		input();
		pro();
	}

	static int N, M;
	// N 명의 학생들 , 학생들의 키를 M번 비교한다.
	static Scanner sc = new Scanner(System.in);
	static LinkedList<Integer>[] list;
	static StringBuilder sb = new StringBuilder();
	static int[] indeg;
	public static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		list = new LinkedList[N + 1];
		indeg = new int[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<>();
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
			if (indeg[i] == 0)
				q.add(i);
		}
		while (!q.isEmpty()) {
			int x = q.poll();
			sb.append(x).append(' ');
			for (int y : list[x]) {
				indeg[y]--;
				if(indeg[y] == 0)
					q.add(y);
			}
		}
		System.out.println(sb);
	}
}
