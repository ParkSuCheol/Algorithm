package Mar;

public class Solution_PG_멀쩡한사각형 {
	public static void main(String[] args) {
		
	}
	public static long solution(int w, int h) {
		long answer = 1;
		long sum = 0;
		if(w == h) {
			sum = w;
		}else {
			sum = w * 2;
		}
		answer = (w*h) - sum;
		return answer;
	}
}
