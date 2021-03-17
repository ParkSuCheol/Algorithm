
public class practice {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,2,7,6,4}));

	}

	public static int solution(int[] nums) {
		int answer = 0;
		for (int i = 0; i < nums.length-2; i++) {
			for (int j = i+1; j < nums.length-1; j++) {
				for (int j2 = j+1; j2 < nums.length; j2++) {
					int sum = nums[i] + nums[j] + nums[j2];
					if(check(sum)) 
						answer++;
				}
			}
		}
		return answer;
	}

	private static boolean check(int sum) {
		for(int i = 2; i*i <= sum; i++ ) {
			if(sum % i == 0) return false;
		}
		return true;
	}

}