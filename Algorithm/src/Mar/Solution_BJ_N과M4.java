package Mar;

import java.util.Scanner;

public class Solution_BJ_N°úM4 {
	static int n,m;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		permutation(0,0);
	}
	private static void permutation(int at, int dept) {
		if(dept == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = at; i < n; i++) {
			arr[dept] = i + 1;
			permutation(i, dept + 1);
		}
	}
}
