package May;

import java.util.*;

public class Solution_PG_KAKAO_로또의최고순위 {
	public static void main(String[] args) {
		int[] lotto= {44, 1, 0, 0, 31, 25};
		int[] chk = {31, 10, 45, 1, 6, 19};
		System.out.println(Arrays.toString(solution(lotto,chk)));
	}
	public static int[] solution(int[] lottos, int[] win_nums) {
        // lottos 내가 고른 수, 0은 어떤 수라도 될 수 있다.
		// win_num 당첨 번호
		// 최고 당첨 등수와 최저 당첨 등수를 return
		int[] answer = new int[2];
		ArrayList<Integer> lotto = new ArrayList<>();
		ArrayList<Integer> win = new ArrayList<>();
		
		int res = 0;
		int cnt = 0;
		for (int i = 0; i < lottos.length; i++) {
			lotto.add(lottos[i]);
			win.add(win_nums[i]);
			if(lottos[i] == 0)
				cnt++;
		}
		for (int i = 0; i < lotto.size(); i++) {
			int ch = lotto.get(i);
			if(win.contains(ch))
				res++;
		}
		int zero = cnt + res;
		int one = res;
		
		zero = 7-zero;
		one = 7-one;
		
		if(zero > 6)
			zero = 6;
		if(one > 6)
			one = 6;
		
		answer[0] = zero;
		answer[1] = one;
		return answer;
    }
}
