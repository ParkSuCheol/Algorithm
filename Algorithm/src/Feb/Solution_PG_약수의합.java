package Feb;

public class Solution_PG_약수의합 {
	public static void main(String[] args) {
		int n = 12;
		System.out.println(Solution(n));
//		Solution(n);
	}
	public static int Solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n/2; i++) {
			if(n % i == 0) {
				answer += i;
			}
		}
		return answer + n;
	}
}
