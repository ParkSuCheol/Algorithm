package Apr;

public class Solution_PG_N개의최소공배수 {
	public static void main(String[] args) {
		int[] arr = { 8,2,14,6 };
		System.out.println(solution(arr));
	}

	public static int solution(int[] arr) {
		int answer = 0;
		int lcm1 = arr[0];
		for (int i = 0; i < arr.length; i++) {
			lcm1 = lcm(lcm1,arr[i]);
		}
		
		return lcm1;
	}
	
	public static int gcd (int a, int b) {
		while(b != 0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
	public static int lcm (int a, int b) {
		return a*b/gcd(a,b);
	}
}
