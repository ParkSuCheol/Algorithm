package Feb;

import java.util.ArrayList;

public class Solution_PG_KAKAO_�����ִ�ȭ {

	public static void main(String[] args) {
		String s = "100-200*300-500+20";
		System.out.println(solution(s));
	}

	static char[] prior = { '+', '-', '*' };
	static boolean[] check = new boolean[3];
	static ArrayList<Long> nums = new ArrayList<Long>();
	static ArrayList<Character> ops = new ArrayList<Character>();
	static long answer;

	public static long solution(String expression) {
		answer = 0;

		String num = "";
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
				num += expression.charAt(i);
			} else {
				nums.add(Long.parseLong(num));
				num = "";
				ops.add(expression.charAt(i));
			}
		}
		nums.add(Long.parseLong(num));

		System.out.println(" num : " + nums + " ops : " + ops);

		dfs(0, new char[3]);
		return answer;
	}

	public static Long calc(Long num1, Long num2, char op) {
		long num = 0;
		switch (op) {
		case '+': {
			return num1 + num2;
		}
		case '-': {
			return num1 - num2;
		}
		case '*': {
			return num1 * num2;
		}
		}
		return num;
	}

	public static void dfs(int count, char[] p) {
		if (count == 3) {
			// ���� ArrayList �� �������ش�.
			ArrayList<Long> cNums = new ArrayList<>(nums);
			ArrayList<Character> cOps = new ArrayList<Character>(ops);
			System.out.println(cNums.size() + " " + cOps.size());

			// �켱������ �°� ���. list index ����!
			// ���ڴ� ������ ���� �׻� 1���� ����.
			for (int i = 0; i < p.length; i++) {
				for (int j = 0; j < cOps.size(); j++) {
					if (p[i] == cOps.get(j)) {
						// ����Ʈ�� ���ﶧ ��ĭ���и��� �迭�� ����� �������� ���ϹǷ�
						// (j �� �ι� remove �ϰ� j-- ó���� ���ذ��̴�.)
						Long res = calc(cNums.remove(j), cNums.remove(j), p[i]);
						cNums.add(j, res);
						cOps.remove(j);
						j--;
					}
				}
			}
			answer = Math.max(answer, Math.abs(cNums.get(0)));
			return;
		}

		// ��� �켱���� ���ձ��ϱ�.
		for (int i = 0; i < 3; i++) {
			if (!check[i]) {
				check[i] = true;
				p[count] = prior[i];
				dfs(count + 1, p);
				check[i] = false;
			}
		}

	}

}