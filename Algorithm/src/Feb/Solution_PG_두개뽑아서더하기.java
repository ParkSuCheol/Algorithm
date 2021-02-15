package Feb;
import java.util.*;

public class Solution_PG_두개뽑아서더하기 {

	public static int[] solution(int[] numbers) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numbers.length -1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				int c = numbers[i] + numbers[j];
				if(!list.contains(c))
					list.add(c);
			}
		}
		
		int [] answer = new int[list.size()];
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		Arrays.sort(answer);
		return answer;
	}
	
	public static void main(String[] args) {
		int[] test1 = {2,1,3,4,1};
		int[] test2 = {5,0,2,7};
		System.out.println(Arrays.toString(solution(test2)));
	}
	
}
