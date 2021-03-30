package Mar;

import java.util.Scanner;

public class Solution_BJ_N°úM {
	static int n, r;
	static int[] arr;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		arr = new int[r];
		v = new boolean[n];
		combi(0);
	}

	private static void combi(int idx) {
		if (idx == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (v[i])
				continue;
			v[i] = true;
			arr[idx] = i + 1;
			combi(idx+1);
			v[i] = false;
		}
	}
}
