package greedy;

import java.util.Scanner;

public class Solution_BJ_연산자끼워넣기 {
	static int N, max, min;
	static int[] nums, operators, order;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[N + 1];
		operators = new int[5];
		order = new int[N + 1];
		for (int i = 1; i <= N; i++)
			nums[i] = sc.nextInt();
		for (int i = 1; i <= 4; i++)
			operators[i] = sc.nextInt();

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		sb = new StringBuilder();

		rec_func(1);
		sb.append(max).append('\n').append(min);
		System.out.println(sb);
	}

	// 완성된 식에 맞게 계산을 해서 정잡에 갱신하는 작업
	static int calculator() {
		// nums, order 배열을 이용해서 계산
		int value = nums[1];
		for (int i = 1; i <= N - 1; i++) {
			// value ,order[i], num[i+1]
			if(order[i] == 1) // +
				value = value + nums[i+1];
			if(order[i] == 2) // -
				value = value - nums[i+1];
			if(order[i] == 3) // *
				value = value * nums[i+1];
			if(order[i] == 4) // /
				value = value / nums[i+1];
		}
		return value;
	}

	// order[1..N-1] 에 연산자들이 순서대로 저장될 것이다.
	static void rec_func(int k) {
		if (k == N) { // 모든 연산자들을 전부 나열하는 방법을 찾은 상태
			// 완성된 식에 맞게 계산을 해서 정잡에 갱신하는 작업
			int value = calculator();
			max = Math.max(max, value);
			min = Math.min(min, value);
		} else {
			// k번째 연산자는 무엇을 선택할 것인가?
			for(int cand = 1; cand <= 4; cand++) {
				if(operators[cand] >= 1) {
					operators[cand]--;
					order[k] = cand;
					rec_func(k+1);
					operators[cand]++;
					order[k] = 0;
				}
			}
		}
	}
}
