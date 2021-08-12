package Aug;

import java.util.*;

public class Solution_PG_여행경로_DFS_BFS {
	public static void main(String[] args) {
		String[][] s = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
		solution(s);
	}

	public static boolean[] v;
	public static String tmp = "";
	public static ArrayList<String> list = new ArrayList<>();

	public static String[] solution(String[][] tickets) {
		for (int i = 0; i < tickets.length; i++) {
			v = new boolean[tickets.length];
			String start = tickets[i][0];
			String end = tickets[i][1];
			if (start.equals("ICN")) {
				v[i] = true;
				tmp = start + ",";
				dfs(tickets, end, 1);
			}
		}
		Collections.sort(list);
		String[] answer = list.get(0).split(",");
		return answer;
	}

	public static void dfs(String[][] tickets, String end, int cnt) {
		tmp += end + ",";
		if (cnt == tickets.length) {
			list.add(tmp);
			return;
		}
		for (int i = 0; i < tickets.length; i++) {
			String s = tickets[i][0];
			String e = tickets[i][1];
			if (end.equals(s) && !v[i]) {
				v[i] = true;
				dfs(tickets, e, cnt + 1);
				v[i] = false;
				tmp = tmp.substring(0, tmp.length() - 4);
			}
		}
	}

}
