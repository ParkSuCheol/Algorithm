package Feb;

public class Solution_PG_서울에서김서방찾기 {
	public static void main(String[] args) {
		String[] arr = {"Jane", "Kim"};
		System.out.println(Solution(arr));
	}
	
	public static String Solution(String[] seoul) {
		String answer = "";
		int res = 0;
		for(int i = 0; i < seoul.length; i++) {
			if(seoul[i].equals("Kim"))
				res = i;
		}
		answer = "김서방은 " + res +"에 있다";
		return answer;
	}
}
