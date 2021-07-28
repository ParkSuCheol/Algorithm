package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_BJ_먹을것인가먹힐것인가 {
	static int[] A, B;
	static int N, M, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	}

	static int lower_bound(int[] A, int L, int R, int X) {
		// A[L...R] 에서 X 미만의 수 (X 보다 작은 수) 중 제일 오른쪽 인덱스를 return 하는 함수
		// 그런게 없다면 L - 1을 return 한다
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
		// B 배열에 대한 이분탐색을 할 예정이니까, 정렬 해주자 !
		Arrays.sort(B, 1, M + 1);

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans += lower_bound(B, 1, M, A[i]);
		}
		System.out.println(ans);
	}
}
