package greedy;

import java.util.Scanner;

public class Solution_BJ_�����ڳ����ֱ�_��ȭ {
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

		rec_func(1,nums[1]);
		sb.append(max).append('\n').append(min);
		System.out.println(sb);
	}

	// �ǿ����� 2���� �����ڰ� �־����� �� ������ִ� �Լ�
	static int calculator(int operand1, int operator, int operand2) {
		// value ,order[i], num[i+1]
		if (operator == 1) // +
			return operand1 + operand2;
		else if (operator == 2) // -
			return operand1 - operand2;
		else if (operator == 3) // *
			return operand1 * operand2;
		else
			return operand1 / operand2;
	}

	// order[1..N-1] �� �����ڵ��� ������� ����� ���̴�.
	static void rec_func(int k, int value) {
		if (k == N) { // ��� �����ڵ��� ���� �����ϴ� ����� ã�� ����
			// �ϼ��� �Ŀ� �°� ����� �ؼ� ���⿡ �����ϴ� �۾�
			max = Math.max(max, value);
			min = Math.min(min, value);
		} else {
			// k��° �����ڴ� ������ ������ ���ΰ�?
			for (int cand = 1; cand <= 4; cand++) {
				if (operators[cand] >= 1) {
					operators[cand]--;
					order[k] = cand;
					rec_func(k + 1, calculator(value, cand, nums[k + 1]));
					operators[cand]++;
					order[k] = 0;
				}
			}
		}
	}
}
