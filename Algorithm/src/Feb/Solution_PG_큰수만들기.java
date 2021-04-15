package Feb;

public class Solution_PG_큰수만들기 {
	public static void main(String[] args) {
		String num = "1924";
		System.out.println(solution(num,2));
	}
	public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        char max;
        
        if(number.charAt(0) == '0') 
        	return "0";
        for(int i = 0; i < number.length() - k; i++) {
        	max = '0';
        	for(int j = idx; j <= k + i; j++) {
        		if( max < number.charAt(j)) {
        			max = number.charAt(j);
        			idx = j+1;
        		}
        	}
        	answer.append(max);
        }
        
        return answer.toString();
    }
}
