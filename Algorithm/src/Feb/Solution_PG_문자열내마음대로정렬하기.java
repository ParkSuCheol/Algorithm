package Feb;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_PG_문자열내마음대로정렬하기 {
	public static void main(String[] args) {
		String[] a = {"sun","bed","car"};
		System.out.println(Arrays.toString(Solution(a,1)));
	}
	public static String[] Solution(String[] strings, int n) {
		
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				char c1 = s1.charAt(n);
				char c2 = s2.charAt(n);
				
				// n번째 문자가 같을 경우에 원본 스트링을 사전순으로
				if(c1 == c2) {
					return s1.compareTo(s2);
				}else 
					return c1 - c2;
			}
		});
		
		return strings;
	}
}
