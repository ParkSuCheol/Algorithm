package Apr;

public class Solution_PG_JadenCase문자열만들기 {
	public static void main(String[] args) {
		String a = " adgagd 3eagdag ";
		System.out.println(solution(a));
	}
	public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean chk = true;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == ' ') {
				chk = true;
				sb.append(c);
				continue;
			}
			if(chk) {
				c = Character.toUpperCase(c);
				chk = false;
			}
			sb.append(c);
		}
        return sb.toString();
    }
}
