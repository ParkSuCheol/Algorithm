package greedy;

import java.util.Scanner;

public class Solution_BJ_부분수열의합 {
	static int N, S, ans;
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
		// ans가 정말 "진 부분집합" 만 다루는지 확인하기
		if( S == 0)
			ans--;
		System.out.println(ans);
	}

	// k번째 원소를 포함시킬지 정하는 함수
	// value:= k-1 번째 원소까지 골라진 원소들의 합
	static void rec_func(int k, int value) {
		if (k == N + 1) { // 부분 수열을 하나 완성 시킨 상태
			// value 가 S랑 같은지 확인하기
			if (value == S)
				ans++;
		} else {
			// k번째 원소를 포함시킬지 결정하고 재귀호출해주기
			// Include
			rec_func(k + 1, value + nums[k]);

			// Not Include
			rec_func(k + 1, value);
		}
	}
}
