package greedy;

import java.util.Scanner;

public class practice {
	static int N,S,ans;
	static int[] nums;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		nums = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			nums[i] = sc.nextInt();
		}
		rec_func(1, 0);
		if( S == 0)
			ans--;
		System.out.println(ans);
	}

	private static void rec_func(int k, int value) {
		if(k == N+1) {
			if(value == S)
				ans++;
			return;
		}else {
			rec_func(k+1,value+nums[k]);
			rec_func(k+1,value);
		}
	}

}
