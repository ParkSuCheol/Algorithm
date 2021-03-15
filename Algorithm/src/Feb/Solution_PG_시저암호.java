package Feb;

public class Solution_PG_시저암호 {
	public static void main(String[] args) {
		String s = "AB";
		System.out.println(Solution(s, 1));
	}

	public static String Solution(String s, int n) {
		String answer = "";
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (temp >= 'a' && temp <= 'z') {
				if (temp + n > 'z') {
					answer += (char) (temp + n-26);
				} else {
					answer += (char)(temp + n);
				}
			} else if (temp >= 'A' && temp <= 'Z') {
				if (temp + n > 'Z') {
					answer += (char) (temp + n-26);
				} else {
					answer += (char)(temp + n);
				}
			} else
				answer += (char)temp;
		}
		return answer;
	}
}
