package Feb;

import java.util.ArrayList;

public class Solution_PG_같은숫자는싫어 {
	public static void main(String[] args) {
		int[] a = {1,1,3,3,3,0,1,1};
		Solution(a);
	}
	
	public static int[] Solution(int[] arr) {
		ArrayList<Integer> temp = new ArrayList<>();
		
		int a = 10;
		for (int i = 0; i < arr.length; i++) {
			if(a != arr[i]) {
				a = arr[i];
				temp.add(a);
			}
			else
				continue;
		}
		
		int[] answer = new int[temp.size()];

		for (int i = 0; i < temp.size(); i++) {
			answer[i] = temp.get(i);
		}
		
		return answer;
	}
}
