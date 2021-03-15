package Feb;

import java.util.*;
public class Solution_PG_정수제곱근판별 {
	public static void main(String[] args) {
		Solution(9);
	}
	public static long Solution(long n) {
		long answer = 0;
		Double as = Math.sqrt(n);
		if(Math.pow(as, 2) == n) {
			return (long)(Math.pow(as+1, 2));
		}else
			return -1;
	}
}
