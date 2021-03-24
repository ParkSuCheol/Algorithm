package Mar;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_PG_기능개발 {
	public static void main(String[] args) {
		int[] a = {95, 90, 99, 99, 80, 99};
		int[] b = {1, 1, 1, 1, 1, 1};
		System.out.println(Arrays.toString(solution(a,b)));
	}
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visit = new boolean[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
        	if(visit[i])
        		continue;
        	visit[i] = true;
			int x = progresses[i];
			int y = speeds[i];
			int day = Math.incrementExact((99 - x)/y);
			System.out.println(day);
			int sum = 1;
			for (int j = i+1; j < progresses.length; j++) {
				if((speeds[j]*day) + progresses[j] < 100)
					break;
				if(!visit[j]) {
					if((speeds[j]*day) + progresses[j] >= 100) {
						visit[j] = true;
						sum++;
					}
				}
			}
			res.add(sum);
        }
//        System.out.println(res);
        answer = new int[res.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = res.get(i);
		}
        return answer;
    }
}
