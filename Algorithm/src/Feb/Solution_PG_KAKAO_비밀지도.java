package Feb;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_PG_KAKAO_비밀지도 {
	public static void main(String[] args) {
		int[] arr1 = {9,20,28,18,11};
		int[] arr2 = {30,1,21,17,28};
		System.out.println(Arrays.toString(solution(5,arr1,arr2)));
	}
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = "";
		}
		for (int i = 0; i < n; i++) {
			StringBuilder si = new StringBuilder();
			StringBuilder sj = new StringBuilder();
			while(true) {	
				si.append(arr1[i] % 2);
				arr1[i] = arr1[i] / 2;
				if(arr1[i]/2 == 0) {
					si.append(arr1[i] % 2);
					break;
				}
			}
			while(!(si.length() == n))
				si.append(0);
			si.reverse();
			
			while(true) {	
				sj.append(arr2[i] % 2);
				arr2[i] = arr2[i] / 2;
				if(arr2[i]/2 == 0) {
					sj.append(arr2[i] % 2);
					break;
				}
			}
			while(!(sj.length() == n))
				sj.append(0);
			sj.reverse();

			char[] ii = new char[n];
			for (int j = 0; j < ii.length; j++) {
				ii[j] = si.charAt(j);
			}
			char[] jj = new char[n];
			for (int j = 0; j < jj.length; j++) {
				jj[j] = sj.charAt(j);
			}
			ArrayList<String> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if(ii[j]== '1' || jj[j] == '1') {
					answer[i] += "#";
				}else
					answer[i] += " ";
			}
		}
		return answer;
	}
}
