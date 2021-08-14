package Aug;

import java.util.*;

public class Solution_PG_다트게임_2018KAKAO {
	public static void main(String[] args) {
		String s = "1S2D*3T";
		solution(s);
	}

	public static int solution(String dartResult) {
		int answer = 0;
		int tmp = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < dartResult.length(); i++) {
			char c = dartResult.charAt(i);
			if (c >= '0' && c <= '9') {
				if (c == '1' && i + 1 < dartResult.length() - 1 && dartResult.charAt(i + 1) == '0') {
					stack.add(10);
					i++;
				} else
					stack.add(c - '0');
			} else {
				if (c == 'S')
					continue;
				else if (c == 'D') {
					tmp = stack.pop();
					tmp = tmp * tmp;
				} else if (c == 'T') {
					tmp = stack.pop();
					tmp = tmp * tmp * tmp;
				} else if (c == '*') {
					tmp = stack.pop();
					tmp = tmp * 2;
					if (!stack.isEmpty()) {
						int tmp2 = stack.pop();
						tmp2 = tmp2 * 2;
						stack.add(tmp2);
					}
				} else if (c == '#') {
					tmp = stack.pop();
					tmp = tmp * -1;
				}
				stack.add(tmp);
			}
		}
		for (int i : stack) {
			answer += i;
		}
		return answer;
	}
}
