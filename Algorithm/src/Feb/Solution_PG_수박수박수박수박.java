package Feb;

public class Solution_PG_수박수박수박수박 {
	public static void main(String[] args) {
		Solution(7);
	}
	
	public static String Solution(int n) {
		String answer="";
		StringBuilder arr = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if(i % 2 == 0)
//				arr.append("수");
				answer += "수";
			else
//				arr.append("박");
				answer += "박";
		}
//		answer = arr.toString();
		return answer;
	}
}
