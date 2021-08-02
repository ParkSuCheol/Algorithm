package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_BJ_�������ΰ��������ΰ� {
	static int[] A, B;
	static int N, M, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	}

	static int lower_bound(int[] A, int L, int R, int X) {
		// A[L...R] ���� X �̸��� �� (X ���� ���� ��) �� ���� ������ �ε����� return �ϴ� �Լ�
		// �׷��� ���ٸ� L - 1�� return �Ѵ�
		int result = L - 1;
		while(L <= R) {
			int mid = (L+R)/2;
			if(A[mid] < X) {
				result = mid;
				L = mid + 1;
			}else if(A[mid] >= X) {
				R = mid - 1;
			}
		}
		return result;
	}

	static void pro() {
		// B �迭�� ���� �̺�Ž���� �� �����̴ϱ�, ���� ������ !
		Arrays.sort(B, 1, M + 1);

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans += lower_bound(B, 1, M, A[i]);
		}
		System.out.println(ans);
	}
}
