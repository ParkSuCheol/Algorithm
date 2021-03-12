package Feb;

public class Solution_PG_문자열내py개수 {
	public static void main(String[] args) {
		String s = "PpPpppoooSSYYyyy";
		System.out.println(Solution(s));
	}
	
	public static boolean Solution(String s) {
		boolean answer = true;
		s = s.toLowerCase();
		int ps = 0;
		int ys = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'p') {
				ps++;
			}
			else if (s.charAt(i) == 'y') {
				ys++;
			}
		}
		if(ps == 0 && ys == 0)
			return true;
		
		return ps==ys?true:false;
	}
}
