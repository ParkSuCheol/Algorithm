
public class toss_3 {
	public static void main(String[] args) {
		String s1 = "10000", s2 = "25,000", s3 = "141,780,000";
		System.out.println(solution(s3));
	}

	public static boolean solution(String amountText) {
		boolean answer = true;
		boolean chk = false;
		for (int i = 0; i < amountText.length(); i++) {
			char c = amountText.charAt(i);
			if (c >= '0' && c <= '9')
				continue;
			if (c == ',') {
				chk = true;
				continue;
			}
			answer = false;
			break;
		}
		if (amountText.charAt(0) == '0' && amountText.length() > 1)
			return answer = false;

		// 100,000,000
		if (chk) {
			if (amountText.charAt(0) == ',')
				return answer = false;
			StringBuilder sb = new StringBuilder(amountText);
			sb = sb.reverse();
			char[] tmp = sb.toString().toCharArray();
			System.out.println(sb);
			int coma = 0;
			for (int i = 0; i < tmp.length; i++) {
				char c = tmp[i];
				if( coma == 3 && c != ',') {
					return answer = false;
				}
				if (c >= '0' && c <= '9') {
					coma++;
				}
				else {
					if (coma == 3) {
						coma = 0;
						continue;
					} else if (coma != 3) {
						return answer = false;
					} 
				}
			}
		}
		return answer;
	}
}
