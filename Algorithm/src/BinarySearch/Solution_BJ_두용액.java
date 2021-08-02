package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_BJ_�ο�� {
	static int[] A;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = sc.nextInt();
		}
		pro();
	}

	static int lower_bound(int[] A, int L, int R, int X) {
		// A[L...R] ���� X �̸��� �� (X ���� ���� ��) �� ���� ������ �ε����� return �ϴ� �Լ�
		// �׷��� ���ٸ� L - 1�� return �Ѵ�
		int res = R+1;
		while(L<+R) {
			int mid = (L+R)/2;
			if(A[mid]>= X) {
				res = mid;
				R = mid - 1;
			}else {
				L = mid + 1;
			}
		}
		return res;
	}

	static void pro() {
		Arrays.sort(A, 1, N + 1);

		int best_sum = Integer.MAX_VALUE;
		int v1 = 0, v2 = 0;
		for (int left = 1; left <= N - 1; left++) {
			// A[left] ����� �� ���̴�. ��� -A[left] �� ���� ����� ����� �ڽ��� ������ �������� ã��.
			int res = lower_bound(A, left + 1, N, -A[left]);

			// A[res - 1] �� A[res] �߿� A[left] �� ������ ���� ������ ���信 ���Ž�Ų��.
			if (left + 1 <= res - 1 && res - 1 <= N && Math.abs(A[res - 1] + A[left]) < best_sum) {
				best_sum = Math.abs(A[left] + A[res-1]);
				v1 = A[left];
				v2 = A[res-1];
			}
			
			if (left + 1 <= res && res  <= N && Math.abs(A[res] + A[left]) < best_sum) {
				best_sum = Math.abs(A[left] + A[res]);
				v1 = A[left];
				v2 = A[res];
			}
		}
		System.out.println(v1 + " " + v2);
	}

}
