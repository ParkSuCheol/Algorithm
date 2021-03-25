package Mar;

public class Solution_PG_KAKAO_문자열압축 {
	public static void main(String[] args) {
		String a = "abcabcdede";
		System.out.println(solution(a));
	}

	public static int solution(String s) {
		int answer = Integer.MAX_VALUE;
		if(s.length() == 1) return 1;
		for (int i = 1; i < s.length(); i++) {
			String now = ""; String comp = "";
			String temp = "";
			int cnt = 1;
			
			for (int j = 0; j <= s.length()/i; j++) {
				int from = i*j; int to = i*(j+1);
				if(to > s.length())
					to = s.length();
				
				now = comp;
				comp = s.substring(from, to);
				
				if(now.equals(comp)) cnt++;
				else {
					if(cnt > 1) temp += String.valueOf(cnt);
					temp += now;
					cnt = 1;
				}
			}
			
			if(cnt > 1) temp += String.valueOf(cnt);
			temp += comp;
			answer = Math.min(temp.length(), answer);
		}
		return answer;
	}
}
