package Sep;

import java.util.*;

public class Solution_PG_입국심사 {
	public static void main(String[] args) {
		int[] s = {7,10};
		System.out.println(solution(6,s));
	}

	public static long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;
		Arrays.sort(times);

		long start, mid, end;
		start = 0;
		end = Long.MAX_VALUE;
		long sum;
		// 모든 사람이 심사 받는데 걸리는 시간 이분 탐색
		// mid : 심사를 받는데 주어진 시간
		// sum : 주어진 시간동안 심사를 받을 수 있는 사람 수
		while (start <= end) {
			mid = (start + end) / 2;
			sum = 0;
			// 주어진 시간동안 몇명 검사 할 수 있는지 누적함
			for (int i = 0; i < times.length; i++) {
				sum += mid / times[i];
				if(sum >= n)
					break;
			}
			// 비교 대상 (사람 수)
			// 검사 다 못할 때
			if( n > sum) {
				start = mid + 1;
			}else {
				end = mid - 1;
				answer = Math.min(answer, mid);
			}
			System.out.println(answer);
		}
		return answer;
	}
}
