package Feb;

public class Solution_PG_Ä«Æê {
	public static void main(String[] args) {
		solution(24, 24);
	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int x = 0;
		int y = 0;
		for (int i = 3; i < brown / 2; i++) {
			x = i;
			y = brown - (x * 2);
			y = (y / 2) + 2;
			if (y < 3)
				continue;
			if ((y - 2) * (x - 2) == yellow) {
				break;
			}
		}
		answer[0] = y;
		answer[1] = x;
		return answer;
	}
}
