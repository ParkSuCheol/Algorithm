package Feb;

public class Solution_PG_자릿수더하기 {
	public static void main(String[] args) {
		Solution(123);
	}
	public static int Solution(int n) {
		int answer = 0;
		String s = String.valueOf(n);
		for(int i = 0; i < s.length(); i++) {
			int j = 0;
			j = (int)s.charAt(i) - 48;
			answer += j;
		}
		int other = 0;
		while(n > 0) {
			other += n%10;
			n /= 10;
		}
		
		return answer;
	}
}
