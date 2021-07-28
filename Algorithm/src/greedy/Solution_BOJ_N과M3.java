package greedy;

import java.util.Scanner;

public class Solution_BOJ_N°úM3 {
	static int M = 0, N = 0;
	static int[] selected;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sb = new StringBuilder();
		selected = new int[M + 1];
		dfs(1);
		System.out.println(sb);
	}

	private static void dfs(int k) {
		if (k == M + 1) {
			for (int i = 1; i < M + 1; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = 1; i <= N; i++) {
				selected[k] = i;
				dfs(k + 1);
			}
		}
	}
}
