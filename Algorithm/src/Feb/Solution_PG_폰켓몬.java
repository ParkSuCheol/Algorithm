package Feb;

import java.util.HashSet;

public class Solution_PG_���ϸ� {
	public static void main(String[] args) {
		int[] arr = {3,1,2,3};
		System.out.println(Solution(arr));
	}
	
	public static int Solution(int[] nums) {
		int answer = 0;
		int max = nums.length / 2;
		// �ߺ� ���Ÿ� ���� HashSet
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
