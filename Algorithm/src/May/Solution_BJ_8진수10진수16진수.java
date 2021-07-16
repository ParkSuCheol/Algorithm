package May;

import java.util.*;

public class Solution_BJ_8진수10진수16진수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = 0;
		StringBuilder sb = new StringBuilder();
		int x = 0;
		if (s.charAt(0) == '0') {
			if (s.charAt(1) == 'x') {
				n = 16;
				s = s.substring(2);
				int sibal = Integer.valueOf(s, 16);
				x = makeNum16(s, n);
				System.out.println(x);
			} else {
				n = 8;
				s = s.substring(1);
				x = makeNum8(s, n);
				System.out.println(x);
			}
		} else {
			System.out.println(s);
		}
	}

	private static int makeNum8(String s, int n) {
		StringBuilder sb = new StringBuilder(s);
		sb = sb.reverse();
		s = sb.toString();
		int sum = 0;
		int target = 0;
		while (target < s.length()) {
			int x = s.charAt(target) - 48;
			if (target == 0)
				sum += x;
			else
				sum += Math.pow(n, target) * x;
			target++;
		}
		return sum;
	}

	private static int makeNum16(String s, int n) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('a', 10);
		map.put('b', 11);
		map.put('c', 12);
		map.put('d', 13);
		map.put('e', 14);
		map.put('f', 15);

		StringBuilder sb = new StringBuilder(s);
		int sum = 0;
		int target = 0;
		sb = sb.reverse();
		s = sb.toString();
		while (target < s.length()) {
			char c = s.charAt(target);
			int x = 0;
			if (!(c >= '0' && c <= '9')) {
				x = map.get(c);
			} else {
				x = s.charAt(target) - 48;
			}
			if (target == 0)
				sum += x;
			else
				sum += Math.pow(n, target) * x;
			target++;
		}
		return sum;
	}
}
