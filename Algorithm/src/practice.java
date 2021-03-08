
public class practice {

	public static void main(String[] args) {
		String a = "...!@BaT#*..y.abcdefghijklm..";

		System.out.println(Solution(a).toString());
	}

	public static String Solution(String new_id) {
		String answer = "";

		// ��� �빮�ڸ� �ҹ��ڷ� ġȯ
		String Step1 = new_id.toLowerCase();

		// ���ĺ�, ����, ����, ����, ��ħǥ ������ ��� ���� ����
		StringBuilder Step2 = new StringBuilder();
		char[] Step1arr = Step1.toCharArray();
		for (char a : Step1arr) {
			if ((a >= '0' && a <= '9') || (a >= 'a' && a <= 'z') || a == '-' || a == '_' || a == '.') {
				Step2.append(a);
			}
		}

		// . �� 2�� �̻� ���ӵ� �κ��� . �� ġȯ
		String Step3 = Step2.toString();
		while (Step3.contains("..")) {
			Step3 = Step3.replace("..", ".");
		}

		// . �� ó���̳� �������� ��ġ�ϸ� �����մϴ�.
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

		// �� ���ڿ��̶�� a �� �����մϴ�.
		if (Step3.length() == 0)
			Step3 = "a";

		// ���̰� 16�� �̻��̸� 15�� ������, ������ . �� �������̸� ��ħǥ ����
		if (Step3.length() >= 16) {
			Step3 = Step3.substring(0, 15);
		}
		if (Step3.length() > 0) {
			if (Step3.charAt(Step3.length() - 1) == '.') {
				Step3 = Step3.substring(0, Step3.length() - 1);
			}
		}

		// ���̰� 2�� ���϶�� ���̰� 3�� �ɶ����� �ݺ��ؼ� ���δ�.
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
