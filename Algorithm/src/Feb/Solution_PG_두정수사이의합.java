package Feb;

public class Solution_PG_�������������� {
	public static void main(String[] args) {
		
	}
	
	public long Solution(int a, int b) {
		long answer = 0;
		int temp = 0;
		
		if(a > b) {
			temp = a;
			a = b;
			b = temp;
		}
		
		for(long i = a; i <= b; i++) {
			answer += i;
		}
		
		return answer;
	}
}
