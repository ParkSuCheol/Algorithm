package Apr;

import java.util.*;

public class Solution_PG_KAKAO_뉴스클리스터링 {
	public static void main(String[] args) {
		String temp1 = "handshake";
		String temp2 = "shake hands";
		solution(temp1,temp2);
	}
	
	public static int solution(String str1, String str2) {
        int answer = 0;
        double com = 0;
        double sum = 0;
        double avg = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        ArrayList<String> a1 = new ArrayList<String>();
        ArrayList<String> a2 = new ArrayList<String>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
			String s = str1.substring(i,i+2);
			if(s.charAt(0) >= 'a' && s.charAt(0) <= 'z' && s.charAt(1) >= 'a' && s.charAt(1) <= 'z') {
				a1.add(s);
			}
		}
        
        for (int i = 0; i < str2.length() - 1; i++) {
			String s = str2.substring(i,i+2);
			if(s.charAt(0) >= 'a' && s.charAt(0) <= 'z' && s.charAt(1) >= 'a' && s.charAt(1) <= 'z') {
				a2.add(s);
			}
		}
        
        for(String s : a1) {
        	if(a2.contains(s)) {
        		com++;
        		a2.remove(s);
        	}
        	System.out.println(a2);
        }
        if(a2.isEmpty() && a1.isEmpty()) {
        	return 65536;
        }

        sum = a1.size() + a2.size();
        avg = com / sum;
        answer = (int)(avg * 65536);
        return answer;
    }
}
