package Feb;

public class Solution_PG_가운데글자가져오기 {

	public static void main(String[] args) {
		String a = "abcde";
		String b = "qwer";
		System.out.println(Solution(a).toString());
	}

	public static String Solution(String s) {
		String answer = "";
		StringBuilder temp = new StringBuilder(s);
		if (temp.length() % 2 == 0) {
			int a = (temp.length() / 2) - 1;
			answer = temp.substring(a, a + 2);
		} else {
			int a = (temp.length() / 2);
			answer = temp.substring(a, a + 1);
		}

		return answer;
	}

	public static String Solution2(String s) {
		System.out.println(s.length());
		System.out.println(s);
		return s.substring((s.length() - 1) / 2, (s.length() / 2) + 1);
	}
}
