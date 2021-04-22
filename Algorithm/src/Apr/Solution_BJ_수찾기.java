package Apr;

import java.util.*;

public class Solution_BJ_¼öÃ£±â {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			int left = 0;
			int right = A.length - 1;
			boolean flag = false;
			while (left <= right) {
				int midIndex = (left + right) / 2;
				int midValue = A[midIndex];
				if (midValue > num)
					right = midIndex - 1;
				else if (midValue < num)
					left = midIndex + 1;
				else {
					flag = true;
					System.out.println(1);
					break;
				}
			}
			if(!flag)
				System.out.println(0);
		}
	}
}
