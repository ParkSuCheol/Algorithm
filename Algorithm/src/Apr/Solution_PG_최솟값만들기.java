package Apr;

import java.util.Arrays;

public class Solution_PG_최솟값만들기 {
	public static void main(String[] args) {
		int[] a = {1,4,2};
		int[] b = {5,4,4};
		System.out.println(solution(a,b));
	}

	public static int solution(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		
		for (int i = 0; i < B.length; i++) {
			answer += A[i] * B[B.length-i-1];
		}
		
		return answer;
	}
}
