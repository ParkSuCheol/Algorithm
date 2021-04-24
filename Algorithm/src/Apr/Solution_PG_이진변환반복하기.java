package Apr;

import java.util.Arrays;

public class Solution_PG_이진변환반복하기 {
	public static void main(String[] args) {
		String s = "1111111";
		System.out.println(Arrays.toString(solution(s)));
	}

	public static int[] solution(String s) {
        int del = 0;
        int cnt = 0;
        while(!s.equals("1")) {
        	cnt++;
        	StringBuilder sb = new StringBuilder();
        	for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '1')
					sb.append('1');
				else
					del++;
			}
        	int temp = sb.length();
        	s = Integer.toBinaryString(temp);
        }
        System.out.println(del + " " + cnt);
        return new int[] {cnt,del};
    }
}
