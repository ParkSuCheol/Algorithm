package Apr;

public class Solution_PG_다음큰숫자 {
	public static void main(String[] args) {
		System.out.println(solution(78));
	}

	public static int solution(int n) {
		int count = Integer.bitCount(n);
		int compare = n + 1;
		while (true) {
			if (Integer.bitCount(compare) == count)
				break;

			compare++;
		}

		return compare;
	}
}
