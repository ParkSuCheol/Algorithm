package Sep;

public class Solution_PG_N으로표현 {
	public static void main(String[] args) {
		solution(5,12);
	}

	static int answer = Integer.MAX_VALUE;
	static int n;
	static int target;

	public static int solution(int N, int number) {
		n = N;
		target = number;
		dfs(0, 0);
		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

	public static void dfs(int count, int prev) {
		if (count > 8) {
			answer = -1;
			return;
		}
		if (prev == target) {
				answer = Math.min(answer, count);
				return;
			}
		int temp = n;

		for (int i = 0; i < 8 - count; i++) {
			int newCount = count + i + 1;
			dfs(newCount, prev + temp);
			dfs(newCount, prev - temp);
			dfs(newCount, prev * temp);
			dfs(newCount, prev / temp);
			temp = (temp * 10) + n;
		}
	}
}
