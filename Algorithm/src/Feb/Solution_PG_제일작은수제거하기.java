package Feb;

import java.util.Arrays;

public class Solution_PG_제일작은수제거하기 {
	public static void main(String[] args) {
		int[] a = {4,3,2,1,};
		System.out.println(Arrays.toString(Solution(a)));
	}
	public static int[] Solution(int[] arr) {
		int[] answer = {};
		if(arr.length == 1) {
			answer = new int[1];
			answer[0] = -1;
			}
		else {
			int Min = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] < Min) {
					Min = arr[i];
				}
			}
			answer = new int[arr.length-1];
			int c = 0;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] != Min) {
					answer[c] = arr[i];
					c++;
				}
			}
			
		}
		return answer;
	}
}
