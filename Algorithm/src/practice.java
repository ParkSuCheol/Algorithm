
public class practice {

	public static void main(String[] args) {
		String a = "...!@BaT#*..y.abcdefghijklm..";

		System.out.println(Solution(a).toString());
	}

	public static String Solution(String new_id) {
		String answer = "";

		// 모든 대문자를 소문자로 치환
		String Step1 = new_id.toLowerCase();

		// 알파벳, 숫자, 빼기, 밑줄, 마침표 제외한 모든 문자 제거
		StringBuilder Step2 = new StringBuilder();
		char[] Step1arr = Step1.toCharArray();
		for (char a : Step1arr) {
			if ((a >= '0' && a <= '9') || (a >= 'a' && a <= 'z') || a == '-' || a == '_' || a == '.') {
				Step2.append(a);
			}
		}

		// . 가 2번 이상 연속된 부분은 . 로 치환
		String Step3 = Step2.toString();
		while (Step3.contains("..")) {
			Step3 = Step3.replace("..", ".");
		}

		// . 가 처음이나 마지막에 위치하면 제거합니다.
		if (Step3.length() > 0) {
			if (Step3.charAt(0) == '.') {
				Step3 = Step3.substring(1, Step3.length());
			}
		}
		if (Step3.length() > 0) {
			if (Step3.charAt(Step3.length() - 1) == '.') {
				Step3 = Step3.substring(0, Step3.length() - 1);
			}
		}

		// 빈 문자열이라면 a 를 대입합니다.
		if (Step3.length() == 0)
			Step3 = "a";

		// 길이가 16자 이상이면 15자 까지만, 제거후 . 가 마지막이면 마침표 제거
		if (Step3.length() >= 16) {
			Step3 = Step3.substring(0, 15);
		}
		if (Step3.length() > 0) {
			if (Step3.charAt(Step3.length() - 1) == '.') {
				Step3 = Step3.substring(0, Step3.length() - 1);
			}
		}

		// 길이가 2자 이하라면 길이가 3이 될때까지 반복해서 붙인다.
		StringBuilder Step4 = new StringBuilder(Step3);
		if (Step4.length() <= 2) {
			char last = Step4.charAt(Step4.length()-1);
			while (Step4.length() <= 2) {
				Step4.append(last);
			}
		}
		
		answer = Step4.toString();
		
		return answer;
	}

}
