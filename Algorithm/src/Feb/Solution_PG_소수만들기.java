package Feb;

import java.util.Arrays;

public class Solution_PG_소수만들기 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,2,3,4}));
	}
	public static int solution(int[] nums) {
		int answer = 0;
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length-2; i++) {
			for (int j = i + 1; j < nums.length-1; j++) {
				for (int j2 = j + 1; j2 < nums.length; j2++) {
					int sum = nums[i] + nums[j] + nums[j2];
					System.out.println(sum);
					if(check(sum)) answer++;
				}
			}
		}
		return answer;
	}
	
	public static boolean check(int n) {
		for(int i = 2; i*i <= n; i++) {
			if(n % i == 0) return false;
		}
		return true;
	}
}
