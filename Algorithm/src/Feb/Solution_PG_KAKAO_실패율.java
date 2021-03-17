package Feb;

import java.util.Arrays;

public class Solution_PG_KAKAO_½ÇÆÐÀ² {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(Arrays.toString(solution(8,arr)));
	}
	public static int[] solution(int N, int[] stages ) {
		int[] answer = new int[N];
		fail[] fails = new fail[N];
		
		double players;
		double inStage;
		for (int i = 1; i <= N; i++) {
			players = 0;
			inStage = 0;
			for (int j = 0; j < stages.length; j++) {
				if(i <= stages[j]) {
					players++;
					if(i == stages[j]) inStage++;
				}
			}
			if(players == 0)
				fails[i-1] = new fail(i,0);
			else
				fails[i-1] = new fail(i, inStage/players);
		}
		
		Arrays.sort(fails,(o1,o2)->{
			return Double.compare(o2.rate, o1.rate);
		});
		
		for (int i = 0; i < N; i++) {
			answer[i] = fails[i].num;
		}
		
		return answer;
	}
	
	public static class fail {
		int num;
		double rate;
		fail(int num, double rate){
			this.num = num;
			this.rate = rate;
		}
	}
}
