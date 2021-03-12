package Feb;

public class Solution_PG_문자열다루기기본 {
	public static void main(String[] args) {
		String s = "124454";
		System.out.println(Solution(s));
	}
	
	public static boolean Solution(String s) {
		boolean answer = true;
		char[] arr = s.toCharArray();
		for (char i : arr) {
			if(i >= 'a' && i <= 'z') {
				return false;
			}
		}
		if(arr.length == 4 || arr.length == 6)
			return true;
		
		return false;
	}
}
