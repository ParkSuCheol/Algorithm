package Mar;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_BJ_N°úM6 {
	static int n,m;
	static int[] arr;
	static int[] res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = sc.nextInt();
		}
		Arrays.sort(res);
		permutation(0,0);
	}
	private static void permutation(int at, int dept) {
		if(dept == m) {
			for(int i : arr)
				System.out.print(res[i - 1] + " ");
			System.out.println();
			return;
		}
		for (int i = at; i < n; i++) {
			arr[dept] = i + 1;
			permutation(i + 1, dept + 1);
		}
	}
}
