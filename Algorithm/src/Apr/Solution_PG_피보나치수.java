package Apr;

public class Solution_PG_피보나치수 {
	public static void main(String[] args) {
		System.out.println(solution(5));
	}

	public static int solution(int n) {
		int[] memo = new int[100001];
		int answer = 0;

		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 1;
		for (int i = 3; i <= n; i++) {
			memo[i] = (memo[i - 1] % 1234567 + memo[i - 2] % 1234567) % 1234567;
		}

		answer = memo[n];
		return answer;
	}
}
