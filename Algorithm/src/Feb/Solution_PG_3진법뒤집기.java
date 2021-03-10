package Feb;

import java.util.ArrayList;

public class Solution_PG_3진법뒤집기 {
	public static void main(String[] args) {
		int n = 45;
		System.out.println(Solution(n));
	}

	public static int Solution(int n) {
		int answer = 0;
		ArrayList<Integer> temp = new ArrayList<>();
		while (true) {
			if (n < 3) {
				temp.add(n);
				break;
			}
			temp.add(n % 3);
			n = n / 3;
		}
		for (int i = 0; i < temp.size(); i++) {
			answer += Math.pow(3, temp.size() - 1 - i) * temp.get(i);
		}

		return answer;
	}
}
