package Sep;

import java.util.*;

public class Solution_PG_�Ա��ɻ� {
	public static void main(String[] args) {
		int[] s = {7,10};
		System.out.println(solution(6,s));
	}

	public static long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;
		Arrays.sort(times);

		long start, mid, end;
		start = 0;
		end = Long.MAX_VALUE;
		long sum;
		// ��� ����� �ɻ� �޴µ� �ɸ��� �ð� �̺� Ž��
		// mid : �ɻ縦 �޴µ� �־��� �ð�
		// sum : �־��� �ð����� �ɻ縦 ���� �� �ִ� ��� ��
		while (start <= end) {
			mid = (start + end) / 2;
			sum = 0;
			// �־��� �ð����� ��� �˻� �� �� �ִ��� ������
			for (int i = 0; i < times.length; i++) {
				sum += mid / times[i];
				if(sum >= n)
					break;
			}
			// �� ��� (��� ��)
			// �˻� �� ���� ��
			if( n > sum) {
				start = mid + 1;
			}else {
				end = mid - 1;
				answer = Math.min(answer, mid);
			}
			System.out.println(answer);
		}
		return answer;
	}
}
