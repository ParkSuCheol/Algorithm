package Mar;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Solution_BJ_N°úM9 {
	static int n,m;
	static int[] arr;
	static int[] res;
	static boolean[] v;
	static LinkedHashSet<String> ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[m];
		v = new boolean[n];
		res = new int[n];
		ans = new LinkedHashSet<>();
		
		for (int i = 0; i < n; i++) {
			res[i] = sc.nextInt();
		}
		Arrays.sort(res);
		permutation(0,0);
		ans.forEach(System.out::println);
		
	}
	private static void permutation(int at, int dept) {
		if(dept == m) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < m; i ++)
				sb.append(arr[i]).append(' ');
			ans.add(sb.toString());
			return;
		}
		for (int i = at; i < n; i++) {
			if(v[i])
				continue;
			v[i] = true;
			arr[dept] = res[i];
			permutation(i + 1,dept + 1);
			v[i] = false;
		}
	}
}
