package PJY;

import java.util.*;

public class Q2 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] { "XYZ", "XWY", "WXA" }, new int[] { 2, 3, 4 })));
	}

	public static String[] solution(String[] orders, int[] course) {
		List<String> list = new ArrayList<>();

		for (int i = 0; i < orders.length; i++) {
			char[] arr = orders[i].toCharArray();
			Arrays.sort(arr);
			String s = "";
			for (int j = 0; j < arr.length; j++) {
				s += arr[j];
			}
			orders[i] = s;
		}

		for (int i = 0; i < course.length; i++) {
			int n = course[i];
			Map<String, Integer> map = new HashMap<>();

			for (int j = 0; j < orders.length; j++) {
				comb(0, 0, "", orders[j], n, map);
			}

			int max = 2;
			List<String> tmp = new ArrayList<>();
			for (String key : map.keySet()) {
				if (map.get(key) > max) {
					tmp.clear();
					tmp.add(key);
					max = map.get(key);
				} else if (map.get(key) == max) {
					tmp.add(key);
				}
			}
			list.addAll(tmp);
		}

		Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
		String[] answer = list.toArray(new String[list.size()]);

		return answer;
	}

	public static void comb(int cnt, int tar, String result, String s, int n, Map<String, Integer> map) {
		if (cnt == n) {
			if (map.containsKey(result))
				map.put(result, map.get(result) + 1);
			else
				map.put(result, 1);
			return;
		} else if (tar == s.length()) {
			return;
		}

		comb(cnt + 1, tar + 1, result + s.charAt(tar), s, n, map);
		comb(cnt, tar + 1, result, s, n, map);
	}
}