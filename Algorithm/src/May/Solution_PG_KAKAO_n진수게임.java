package May;

import java.util.*;

public class Solution_PG_KAKAO_n진수게임 {
	public static void main(String[] args) {
		System.out.println(solution(16, 16, 2, 1));
	}

	static Map<Integer, String> map;

	public static String solution(int n, int t, int m, int p) {
		map = new HashMap<>();
		map.put(10, "A");
		map.put(11, "B");
		map.put(12, "C");
		map.put(13, "D");
		map.put(14, "E");
		map.put(15, "F");

		// n진법, 숫자 갯수 t
		// 참가인원 m, 튜브 순서 p

		StringBuilder sb = new StringBuilder();
		StringBuilder ans = new StringBuilder();
		sb.append("0");
		int num = 1;
		while (sb.length() < (t * m) + p) {
			sb.append(getNumber(num, n));
			num++;
		}
		char[] c = sb.toString().toCharArray();
		System.out.println(Arrays.toString(c));
		for (int i = p - 1; i < (t * m) + p - 1; i += m) {
			ans.append(c[i]);
		}
		return ans.toString().toUpperCase();
	}

	private static Object getNumber(int num, int n) {
		// num을 n진수로 변환하는 함수
		if (num < n)
			if (n > 10 && num > 9)
				return map.get(num) + "";
			else
				return num + "";

		StringBuilder tmp = new StringBuilder();
		int m = num;
		int last = 0;
		while (m >= n) {
			last = m % n;
			m = m / n;
			if (n > 10 && last > 9) {
				tmp.append(map.get(last));
			} else {
				tmp.append(last);
			}
		}
		if (n > 10 && m > 9)
			tmp.append(map.get(m));
		else
			tmp.append(m);

		return tmp.reverse().toString();
	}
}
