package Mar;

public class Solution_PG_124나라의숫자 {
	public static void main(String[] args) {
		System.out.print(solution(7));
	}
	public static String solution(int n){
		String[] numbers = {"4","1","2"};
		String answer = "";
		
		int num = n;
		
		while(num > 0) {
			int remainder = num % 3;
			num /= 3;
			if(remainder == 0) num--;
			answer = numbers[remainder] + answer;
		}
		return answer;
	}
}
