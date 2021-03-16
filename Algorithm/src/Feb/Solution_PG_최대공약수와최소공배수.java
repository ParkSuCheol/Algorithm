package Feb;

public class Solution_PG_최대공약수와최소공배수 {
	public static void main(String[] args) {
		
	}
	public static int[] solution(int n, int m) {
		int[] answer = new int[2];
		answer[0] = gcd(n,m);
		answer[1] = n* m / answer[0];
		return answer;
	}
	static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
