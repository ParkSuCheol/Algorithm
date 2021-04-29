package Apr;

public class Solution_PG_�������ǥ {
	public static void main(String[] args) {
		System.out.println(solution(8, 4, 7));
	}

	public static int solution(int n, int a, int b) {
		int answer = 1;
		int left = 0;
		int right = 0;

		if (a > b) {
			right = a;
			left = b;
		} else {
			right = b;
			left = a;
		}

		while (true) {
			if (left % 2 != 0 && right - left == 1) {
				break;
			}
			left = (left + 1) / 2;
			right = (right + 1) / 2;
			answer++;
		}

		return answer;
	}
}
