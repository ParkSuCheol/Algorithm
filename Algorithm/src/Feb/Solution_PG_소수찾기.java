package Feb;

public class Solution_PG_소수찾기 {
	public static void main(String[] args) {
		int i = 12;
		System.out.println(Solution(i));
	}
	
	public static int Solution(int n) {
		int answer = 0;
		boolean[] checked = new boolean[n+1];
		
		for (int i = 2; i <= n; i++) {
			if(!checked[i])
				answer++;
			for (int j = i; j <= n; j += i) {
				if(!checked[j])
					checked[j] = true;
			}
		}
		return answer;
	}
}
