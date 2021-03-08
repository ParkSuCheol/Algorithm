package Mar;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_PG_모의고사 {
	public static void main(String[] args) {
		int[] a = { 1,2,3,4,5 };
		Solution(a);
		
		System.out.println(Arrays.toString(Solution(a)));
	}

	public static int[] Solution(int[] answers) {
		int[] answer = {};
		int[] st1 = { 1, 2, 3, 4, 5 };
		int[] st2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] st3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		
		
		
		int st1_cnt = 0, st2_cnt = 0, st3_cnt = 0;

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == st1[i % 5])
				st1_cnt++;
			if (answers[i] == st2[i % 8])
				st2_cnt++;
			if (answers[i] == st3[i % 10])
				st3_cnt++;
		}
		
		int[] score = new int[3];
		score[0] = st1_cnt;
		score[1] = st2_cnt;
		score[2] = st3_cnt;
		
		int max = Math.max(st1_cnt, Math.max(st2_cnt, st3_cnt));
		
		ArrayList<Integer> a = new ArrayList<>();
		
		for(int i = 0; i < score.length; i++) {
			if(score[i] == max) {
				a.add(i + 1);
			}
		}
		answer = new int[a.size()];
		
		for (int i = 0; i < a.size(); i++) {
			answer[i] = a.get(i);
		}
		
		return answer;
	}
}
