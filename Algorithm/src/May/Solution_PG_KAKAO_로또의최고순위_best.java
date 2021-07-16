package May;

import java.util.Arrays;

public class Solution_PG_KAKAO_로또의최고순위_best {
	public static void main(String[] args) {
		int[] lotto= {44, 1, 0, 0, 31, 25};
		int[] chk = {31, 10, 45, 1, 6, 19};
		System.out.println(Arrays.toString(solution(lotto,chk)));
	}
	public static int[] solution(int[] lottos, int[] win_nums) {
		int zero = 0;
		int matched = 0;
		for(int l : lottos) {
			if(l == 0)
				zero++;
			else {
				for(int w : win_nums) {
					if(l == w) {
						matched++;
						break;
					}
				}
			}
		}
		int min = matched;
		int max = matched + zero;
		int[] answer = {Math.min(7-max, 6),Math.min(7-min, 6)};
		return answer;
	}
}
