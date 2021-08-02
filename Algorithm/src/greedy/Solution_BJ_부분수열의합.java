package greedy;

import java.util.Scanner;

public class Solution_BJ_�κм������� {
	static int N, S, ans;
	static int[] nums;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		nums = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			nums[i] = sc.nextInt();
		}
		rec_func(1, 0);
		// ans�� ���� "�� �κ�����" �� �ٷ���� Ȯ���ϱ�
		if( S == 0)
			ans--;
		System.out.println(ans);
	}

	// k��° ���Ҹ� ���Խ�ų�� ���ϴ� �Լ�
	// value:= k-1 ��° ���ұ��� ����� ���ҵ��� ��
	static void rec_func(int k, int value) {
		if (k == N + 1) { // �κ� ������ �ϳ� �ϼ� ��Ų ����
			// value �� S�� ������ Ȯ���ϱ�
			if (value == S)
				ans++;
		} else {
			// k��° ���Ҹ� ���Խ�ų�� �����ϰ� ���ȣ�����ֱ�
			// Include
			rec_func(k + 1, value + nums[k]);

			// Not Include
			rec_func(k + 1, value);
		}
	}
}
