package Sep;

import java.util.*;

public class Solution_PG_�ٴܰ�ĩ���Ǹ� {
	public static void main(String[] args) {
		String[] en = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
		String[] re = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
		String[] se = { "young", "john", "tod", "emily", "mary" };
		int[] am = { 12, 4, 2, 5, 10 };
		solution(en, re, se, am);
	}

	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length];

		Map<String, String> parentMap = new HashMap<>(); // �ڽ�, �θ�
		Map<String, Integer> memberIndexMap = new HashMap<>(); // �ڽ�, �ڽ��� ����

		for (int i = 0; i < enroll.length; i++) {
			parentMap.put(enroll[i], referral[i]);
			memberIndexMap.put(enroll[i], i);
		}

		for (int i = 0; i < seller.length; i++) {

			String now = seller[i];
			int profit = 100 * amount[i];

			while (!now.equals("-")) {
				int profitForParent = profit / 10; // �θ𿡰� �Ѱ��� �ݾ�
				int nowProfit = profit - profitForParent; // �ڽ��� ������ �ݾ�

				// �ڽ��� index�� �ݾ׸�ŭ ����
				answer[memberIndexMap.get(now)] += nowProfit;

				// ���� �θ�� �̵��ϸ鼭 ������ �θ𿡰� �Ѱ��� �ݾ����� �ʱ�ȭ
				now = parentMap.get(now);
				profit /= 10;

				// 10%�� �ݾ��� 1�� �̸��� ���
				if (profit < 1) {
					break;
				}
			}
		}

		return answer;
	}

}
