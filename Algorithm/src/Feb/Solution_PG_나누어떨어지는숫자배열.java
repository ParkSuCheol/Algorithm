package Feb;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_PG_나누어떨어지는숫자배열 {
	public static void main(String[] args) {
		int[] array = {5, 9, 7, 10};
		System.out.println(Arrays.toString(Solution(array,5)));
	}
	
	public static int[] Solution(int[] arr, int divisor) {
		ArrayList<Integer> temp = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % divisor == 0) {
				temp.add(arr[i]);
			}
		}
		
		if(temp.size() == 0)
			temp.add(-1);
		
		int[] answer = new int[temp.size()];

		for (int i = 0; i < temp.size(); i++) {
			answer[i] = temp.get(i);
		}
		
		Arrays.sort(answer);
		
		return answer;
	}
}
