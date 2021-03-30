package Mar;

import java.util.Scanner;

public class Solution_BJ_N°úM3 {
	static int n,m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		permutation(0);
		System.out.print(sb);
	}
	private static void permutation(int depth) {
		if(depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < n; i++) {
			arr[depth] = i + 1;
			permutation(depth + 1);
		}
	}
}
