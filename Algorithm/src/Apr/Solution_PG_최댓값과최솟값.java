package Apr;

import java.util.Arrays;

public class Solution_PG_ÃÖ´ñ°ª°úÃÖ¼Ú°ª {
	public static void main(String[] args) {
		String s = "-1 -1";
		System.out.println(solution(s));
	}
	public static String solution(String s) {
        String answer = "";
        
        String[] arr = new String[s.length()];
        arr = s.split(" ");
        
        int[] temp = new int[arr.length];
        
        for (int i = 0; i < temp.length; i++) {
			temp[i] = Integer.parseInt(arr[i]);
		}
        
        Arrays.sort(temp);
        
        answer += temp[0];
        answer += " ";
        answer += temp[temp.length-1];
        
        return answer;
    }
}
