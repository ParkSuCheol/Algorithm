package Feb;

public class Solution_PG_자연수뒤집어배열로만들기 {
	public static void main(String[] args) {
		int n = 12345;
		Solution(n);
	}
	public static int[] Solution(long n) {
		int[] answer = {};
		StringBuilder s = new StringBuilder();
		s.append(n);
		System.out.println(s);
		s = s.reverse();
		answer = new int[s.length()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = s.charAt(i) - 48;
		}
		
		
		// 다른 방법
		String st = String.valueOf(n);
		StringBuilder sb = new StringBuilder(st);
		sb.reverse();
		String[] ss = sb.toString().split("");
		
		int[] other = new int[ss.length];
		for (int i = 0; i < other.length; i++) {
			other[i] = Integer.parseInt(ss[i]);
		}
		
		
		
		return answer;
	}
}
