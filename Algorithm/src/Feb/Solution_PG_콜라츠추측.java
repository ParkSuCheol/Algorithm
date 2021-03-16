package Feb;

public class Solution_PG_Äİ¶óÃ÷ÃßÃø {
	public static void main(String[] args) {
		System.out.println(solution(626331));
	}
	public static int solution(int num) {
		int answer = 0;
		long as = num;
		while(true) {
			if(as == 1)
				break;
			if( answer >= 500) {
				answer = -1;
				break;
			}
			
			if(as % 2 == 0) {
				as = as / 2;
			}else {
				as = (as * 3) + 1;
			}
			answer++;
		}
		return answer;
	}
}
