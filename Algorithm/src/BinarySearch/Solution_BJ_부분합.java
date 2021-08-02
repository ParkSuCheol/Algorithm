package BinarySearch;

import java.util.Scanner;

public class Solution_BJ_ºÎºÐÇÕ {
	static int N,S;
	static int[] a;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		pro();
	}

	private static void pro() {
		int L = 0, R = 0, sum = 0, ans = 100001;
		while(true) {
			if(sum >= S) {
				sum -= a[L];
				ans = Math.min(ans, R-L);
				L++;
			}
			else if (R == N) break;
			else {
				sum += a[R];
				R++;
			}
		}
		if(ans == 100001) {
			ans = 0;
		}
		System.out.println(ans);
	}
}
