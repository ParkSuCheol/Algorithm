package Feb;

import java.util.*;

public class Solution_PG_구명보트 {
	public static void main(String[] args) {
		int[] a = { 20, 80, 20, 80 };

		System.out.println(solution(a, 100));
	}

	public static int solution(int[] people, int limit) {
		int answer = 0;
		
		Arrays.sort(people);
		int i = 0;
		int j = people.length-1;
		
		while(i < j) {
			if(people[i] + people[j] <= limit)
				i++;
			j--;
			answer++;
		}
		
		if( i == j)
			answer++;
		
		return answer;
	}
}
