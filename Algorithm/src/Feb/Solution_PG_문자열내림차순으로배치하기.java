package Feb;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_PG_문자열내림차순으로배치하기 {
	public static void main(String[] args) {
		String s = "Zbcdefg";
		System.out.println(Solution(s));
	}
	
	public static String Solution(String s) {
		String answer = "";
		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			arr.add(s.charAt(i)+"");
		}
		Collections.sort(arr);
		StringBuilder res = new StringBuilder();
		
		for (int i = arr.size()-1; i >= 0; i--) {
			res.append(arr.get(i));
		}
		
		answer = res.toString();
		
		//answer = res.reverse().toString();
		
		return answer;
	}
}
