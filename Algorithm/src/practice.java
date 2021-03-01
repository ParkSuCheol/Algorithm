
public class practice {

	public static void main(String[] args) {
		String a = "...!@BaT#*..y.abcdefghijklm";
		
		System.out.println(Solution(a).toString());
	}
	
	public static String Solution(String new_id) {
		String answer = "";
		
		// 1�ܰ�  ��� �빮�ڸ� �ҹ��ڷ�
		String step1 = new_id.toLowerCase();
		
		// 2�ܰ� ���ĺ� �ҹ���, ����, - _ . �ܿ� �� ����
		StringBuilder step2 = new StringBuilder();
		char[] step1_arr = step1.toCharArray();
		for(char c : step1_arr) {
			if( (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || c == '_' || c == '-' || c == '.') {
				step2.append(c);
			}
		}
		
		// 3�ܰ� .�� 2�� �̻� ���ӵǸ� .�ϳ��� ġȯ
		String step3 = step2.toString();
		while(step3.contains("..")) {
			step3 = step3.replace("..",".");
		}
		
		// 4�ܰ� . �� ó���̳� �������̸� ����
		String step4 = step3;
		if (step4.length() > 0) {
			if (step4.charAt(0) == '.') {
				step4 = step4.substring(1, step4.length());
			}
		}
		if (step4.length() > 0) {
			if (step4.charAt(step4.length() - 1) == '.') {
				step4 = step4.substring(0, step4.length() - 1);
			}
		}
		
		// 5�ܰ� �� ���ڿ��̸� a ����
		String step5 = step4;
		if(step5 == "")
			step5 = "a";
		
		// 6�ܰ� ���̰� 16 �̻��̸� 15����, .�� �������� ���´ٸ� ����
		String step6 = step5;
		if(step6.length() >= 16)
			step6 = step6.substring(0,15);
		if(step6.charAt(step6.length()-1) == '.')
			step6 = step6.substring(0,step6.length() - 1);
		
		// 7�ܰ�
		StringBuilder step7 = new StringBuilder(step6);
		if(step7.length() <= 2) {
			char last = step7.charAt(step7.length() - 1);
			
			while(step7.length() < 3) {
				step7.append(last);
			}
		}
		
		
		
		answer = step7.toString();
		
		return answer;
	}

}
