package Feb;

import java.util.HashSet;

public class Solution_PG_폰켓몬 {
	public static void main(String[] args) {
		int[] arr = {3,1,2,3};
		System.out.println(Solution(arr));
	}
	
	public static int Solution(int[] nums) {
		int answer = 0;
		int max = nums.length / 2;
		// 중복 제거를 위한 HashSet
		HashSet<Integer> numSet = new HashSet<>();
		for(int num : nums) {
			numSet.add(num);
		}
		
		if(numSet.size() > max) {
			return max;
		} else {
			return numSet.size();
		}
	}
	
}
