import java.util.Arrays;

public class practice {

	public static void main(String[] args) {
		int[] arr1 = {9,20,28,18,11};
		int[] arr2 = {30,1,21,17,28};
		System.out.println(Arrays.toString(solution(5,arr1,arr2)));
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			String temp1 = Integer.toBinaryString(arr1[i] | arr2[i]);
			
			if(temp1.length() != n) {
				while(!(temp1.length() == n)) {
					temp1 = "0"+temp1;
				}
			}
			temp1 = temp1.replaceAll("1","#");
			temp1 = temp1.replaceAll("0", " ");
			answer[i] = temp1;
		}
		return answer;
	}
}