package Feb;

public class Solution_PG_x��ŭ�������ִ�n���Ǽ��� {
	public static void main(String[] args) {

	}

	public static long[] solution(int x, int n) {
		long[] answer = {};
		answer = new long[n];
		long a = 1;
		for (int i = 0; i < n; i++) {
			answer[i] += x * a;
			a++;
		}
		return answer;
	}
}
