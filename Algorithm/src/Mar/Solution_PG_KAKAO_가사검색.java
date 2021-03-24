package Mar;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_PG_KAKAO_가사검색 {
	public static void main(String[] args) {
		String[] a = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] b = { "fro??", "????o", "fr???", "fro???", "pro?" };
		System.out.println(Arrays.toString(solution(a, b)));
	}

	public static int[] solution(String[] words, String[] queries) {
		int[] answer = {};
		answer = new int[words.length - 1];
		int k = 0;
		for (String s : queries) {
			char[] c = s.toCharArray();
			boolean chk = true;
			int sum = 0;
			String temp = "";
			for (int i = 0; i < c.length; i++) {
				if (c[i] != '?')
					temp += c[i];
				if (i == 0 && c[i] == '?')
					chk = false;
				// true 는 정방향, false 는 역방향
			}
			ArrayList<String> ag = new ArrayList<String>();
			
			System.out.print(temp + " : ");
			for (String ss : words) {
				System.out.print(ss + " ");
				if (chk) {
					if (ss.startsWith(temp) && ss.length() == s.length()) {
						sum++;
					}
				} else if (!chk) {
					if (ss.endsWith(temp) && ss.length() == s.length()) {
						sum++;
					}
				}
			}
			System.out.println();
			answer[k] = sum;
			k++;
		}
		return answer;
	}
}
