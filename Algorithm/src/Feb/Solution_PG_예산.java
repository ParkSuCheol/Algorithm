package Feb;

import java.util.Arrays;

public class Solution_PG_¿¹»ê {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2,2,3,3},10));
	}
	public static int solution(int[] d, int budget) {
		int answer = 0;
		Arrays.sort(d);
		for(int i : d) {
			budget -= i;
			if(budget < 0) {
				break;
			}
			answer++;
		}
		return answer;
	}
}
