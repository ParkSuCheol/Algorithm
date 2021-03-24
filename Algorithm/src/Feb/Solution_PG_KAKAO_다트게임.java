package Feb;

import java.util.Stack;

public class Solution_PG_KAKAO_다트게임 {
	public static void main(String[] args) {
		String a = "1D2S#10S";
//		System.out.println(solution(a));
		solution(a);
	}

	public static int solution(String dartResult) {
		int answer = 0;
		char[] dart = dartResult.toCharArray();
		int num = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < dart.length; i++) {
			if (dart[i] >= '0' && dart[i] <= '9') {
				if (dart[i] == '1') {
					if (i + 1 < dart.length - 1 && dart[i + 1] == '0' && dart[i] == '1') {
						num = 10;
						i++;
					} else
						num = 1;
				} else {
					num = (int) dart[i] - 48;
				}
				stack.push(num);
			} else {
				int prev = stack.pop();
				if (dart[i] == 'D') {
					prev = (prev * prev);
				} else if (dart[i] == 'T') {
					prev = prev * prev * prev;
				}
				if (dart[i] == '*') {
					prev = prev * 2;
					if (!stack.isEmpty()) {
						int temp = stack.pop();
						temp = temp * 2;
						stack.push(temp);
					}
				} else if (dart[i] == '#') {
					prev = prev * -1;
				}
				stack.push(prev);
			}
		}
		while (!stack.isEmpty()) {
			answer += stack.pop();
		}
		System.out.println(answer);
		return answer;
	}
}
