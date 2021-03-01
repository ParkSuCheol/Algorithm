
public class practice {

	public static void main(String[] args) {
		String a = "...!@BaT#*..y.abcdefghijklm";
		
		System.out.println(Solution(a).toString());
	}
	
	public static String Solution(String new_id) {
		String answer = "";
		
		// 1단계  모든 대문자를 소문자로
		String step1 = new_id.toLowerCase();
		
		// 2단계 알파벳 소문자, 숫자, - _ . 외에 다 삭제
		StringBuilder step2 = new StringBuilder();
		char[] step1_arr = step1.toCharArray();
		for(char c : step1_arr) {
			if( (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || c == '_' || c == '-' || c == '.') {
				step2.append(c);
			}
		}
		
		// 3단계 .가 2번 이상 연속되면 .하나로 치환
		String step3 = step2.toString();
		while(step3.contains("..")) {
			step3 = step3.replace("..",".");
		}
		
		// 4단계 . 이 처음이나 마지막이면 제거
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
		
		// 5단계 빈 문자열이면 a 대입
		String step5 = step4;
		if(step5 == "")
			step5 = "a";
		
		// 6단계 길이가 16 이상이면 15까지, .이 마지막에 들어온다면 제거
		String step6 = step5;
		if(step6.length() >= 16)
			step6 = step6.substring(0,15);
		if(step6.charAt(step6.length()-1) == '.')
			step6 = step6.substring(0,step6.length() - 1);
		
		// 7단계
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
