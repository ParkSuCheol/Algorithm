package Feb;

public class Solution_PG_���� {
	public static void main(String[] args) {
		
	}
	public static int Solution(int[] a, int[] b) {
		int answer = 0;
		
		for (int i = 0; i < b.length; i++) {
			answer += a[i] * b[i];
		}
		return answer;
	}
}
