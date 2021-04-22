package Apr;

import java.util.*;

public class Solution_PG_KAKAO_Æ©ÇÃ {
	public static void main(String[] args) {
		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		System.out.println(Arrays.toString(solution(s)));
	}

	public static int[] solution(String s) {
		s = s.substring(2, s.length() - 2).replace("},{", "-");
		String[] arr = s.split("-");

		Arrays.sort(arr, (a, b) -> {
			return a.length() - b.length();
		});

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}System.out.println();
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (String temp : arr) {
			String[] val = temp.split(",");
			for (int i = 0; i < val.length; i++) {
				int num = Integer.valueOf(val[i]);

				if (!list.contains(num)) {
					list.add(num);
				}
			}
		}

		int[] answer = new int[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
}
