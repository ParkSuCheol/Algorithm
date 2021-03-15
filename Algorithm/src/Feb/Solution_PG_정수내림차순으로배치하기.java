package Feb;

import java.util.*;

public class Solution_PG_정수내림차순으로배치하기 {
	public static void main(String[] args) {
		long s = 118372;
		Solution(s);
	}

	public static long Solution(long n) {
		long answer = 0;
		String ansnum = "";
		String s = String.valueOf(n);
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			ansnum += arr[i];
		}
		answer = Long.parseLong(ansnum);

		String[] lists = String.valueOf(n).split("");
		Arrays.sort(lists);
		StringBuilder sb = new StringBuilder();
		for(String aList : lists)
			sb.append(aList);
		
//		return Long.parseLong(sb.reverse().toString());
		
		return answer;
	}
}
