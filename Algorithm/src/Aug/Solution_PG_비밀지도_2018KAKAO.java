package Aug;

public class Solution_PG_비밀지도_2018KAKAO {
	public static void main(String[] args) {
		int[] a = {9, 20, 28, 18, 11};
		int[] b = {30, 1, 21, 17, 28};
		solution(5,a,b);
	}
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for(int i = 0; i < n; i++) {
			String tmp = Integer.toBinaryString(arr1[i] | arr2[i]);
			
			if(tmp.length() != n) {
				while(tmp.length() != n) {
					tmp = "0" + tmp;
				}
			}
			
			tmp = tmp.replaceAll("0", " ");
			tmp = tmp.replaceAll("1", "#");
			answer[i] = tmp;
		}
		
		return answer;
	}
}
