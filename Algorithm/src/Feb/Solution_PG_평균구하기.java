package Feb;


public class Solution_PG_Æò±Õ±¸ÇÏ±â {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{5,5}));
	}
	public static double solution(int[] arr) {
		double answer = 0;
		
		for(int i : arr) {
			answer += i;
		}
		answer = answer / arr.length;
		
		return answer;
	}
}
