package Apr;

public class Solution_PG_¿Ã¹Ù¸¥°ýÈ£ {
	public static void main(String[] args) {
		String s = "(()(";
		System.out.println(solution(s));
	}

	public static boolean solution(String s) {
		boolean answer = false;
		int a = 0, b = 0;
		for (int i = 0; i < s.length(); i++) {
			if(!(s.charAt(0) == '(')){
				a = -1;
				break;
			}
			if(s.charAt(i) == '(')
				a++;
			else 
				a--;
			
			if( a < 0)
				break;
		}
		if(a == 0) 
			answer = true;

		return answer;
	}
}
