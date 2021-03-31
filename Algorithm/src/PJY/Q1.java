package PJY;

public class Q1 {
	public static void main(String[] args) {
		System.out.println(solution("=.="));
	}

	public static String solution(String new_id) {
		// 1
		new_id = new_id.toLowerCase();
		String tmp = "";

		// 2
		for (int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.')
				tmp += c;
		}
		new_id = tmp;
		char now = new_id.charAt(0);
		tmp = now + "";

		// 3
		for (int i = 1; i < new_id.length(); i++) {
			char c = new_id.charAt(i);

			if (now == '.' && c == '.')
				continue;

			tmp += c;
			now = c;
		}
		new_id = tmp;

		// 4
		if (new_id.charAt(0) == '.')
			new_id = new_id.substring(1);
		if (new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.')
			new_id = new_id.substring(0, new_id.length() - 1);

		// 5
		if (new_id.length() == 0)
			new_id = 'a' + "";

		// 6
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			if (new_id.charAt(new_id.length() - 1) == '.')
				new_id = new_id.substring(0, 14);
		}
		// 7
		if (new_id.length() <= 2) {
			while (new_id.length() < 3)
				new_id += new_id.charAt(new_id.length() - 1);
		}

		return new_id;
	}
}