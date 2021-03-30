package Mar;

import java.util.*;

public class Solution_PG_KAKAO_메뉴리뉴얼 {
	public static void main(String[] args) {
		String[] order = { "XYZ", "XWY", "WXA"};
		int[] course = { 2, 3, 4 };
		solution(order, course);
	}

	static char dfs_str[];
	static boolean v[];
	static String s;
	static int end;
	static int max_value[];
	static int max_len = 0;
	static int cnt = 0;
	static HashMap<String, Integer> map = new HashMap<>();

	public static String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		for (int i = 0; i < orders.length; i++) {
			String[] tmp = orders[i].split("");
			max_len = Math.max(max_len, orders[i].length());
			Arrays.sort(tmp);

			String sort_str = "";

			for (int j = 0; j < tmp.length; j++) {
				sort_str += tmp[j];
			}
			orders[i] = sort_str;

			for (int j = 0; j < course.length; j++) {
				end = course[j];
				v = new boolean[orders[i].length()];
				dfs_str = new char[end];
				dfs(0, 0, orders[i]);
			}
			max_value = new int[max_len + 1];
			ArrayList<String> list = new ArrayList<>();

			for (String key : map.keySet()) {
				max_value[key.length()] = Math.max(max_value[key.length()], map.get(key));
			}

			for (String key : map.keySet()) {
				for (int j = 0; j < course.length; j++) {
					if (key.length() == course[j] && map.get(key) == max_value[key.length()] && map.get(key) >= 2) {
						list.add(key);
					}
				}
			}
			Collections.sort(list);
			answer = new String[list.size()];
			for (int k = 0; k < answer.length; k++) {
				answer[k] = list.get(k);
			}
			System.out.println(list);
		}
		return answer;
	}

	private static void dfs(int at, int dept, String str) {
		if (dept == end) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < end; i++) {
				sb.append(dfs_str[i]);
			}

			if (map.containsKey(sb.toString())) {
				int a = map.remove(sb.toString());
				map.put(sb.toString(), a + 1);
			} else {
				map.put(sb.toString(), 1);
			}
			return;
		}
		for (int i = at; i < str.length(); i++) {
			if (v[i])
				continue;
			dfs_str[dept] = str.charAt(i);
			v[i] = true;
			dfs(i + 1, dept + 1, str);
			v[i] = false;
		}
	}

}
