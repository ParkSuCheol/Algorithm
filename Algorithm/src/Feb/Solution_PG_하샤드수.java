package Feb;

public class Solution_PG_ÇÏ»þµå¼ö {
	public static void main(String[] args) {
		System.out.println(solution(11));
	}
	public static boolean solution(int x) {
		String s = String.valueOf(x);
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i) - 48;
		}
		if(x % sum == 0)
			return true;
		return false;
	}
}
