package Feb;

public class Solution_PG_핸드폰번호가리기 {
	public static void main(String[] args) {
		String s = "023334444";
		System.out.println(solution(s));
	}
	public static String solution(String phone_number) {
		String answer = "";
		for (int i = 0; i < phone_number.length()-4; i++) {
			answer += "*";
		}
		answer += phone_number.substring(phone_number.length()-4,phone_number.length());
		
		char[] ch = phone_number.toCharArray();
		for (int i = 0; i < ch.length-4; i++) {
			ch[i] = '*';
		}
//		return String.valueOf(ch);
		
		return answer;
	}
}
