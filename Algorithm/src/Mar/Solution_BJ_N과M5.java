package Mar;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_BJ_N°úM5 {
	static int n,m;
	static int[] arr;
	static int[] res;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		res = new int[n];
		for(int i = 0; i < n; i++) {
			res[i] = sc.nextInt();
		}
		Arrays.sort(res);
		
		v = new boolean[n];
		permutation(0);
		
	}
	private static void permutation(int dept) {
		if(dept == m) {
			for(int i = 0; i < m; i++) {
				System.out.print(res[arr[i]-1] + " ");
			}System.out.println();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(v[i])
				continue;
			v[i] = true;
			arr[dept] = i + 1;
			permutation(dept + 1);
			v[i] = false;
		}
	}
}
