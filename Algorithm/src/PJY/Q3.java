package PJY;

import java.util.*;

public class Q3 {
	static String[][] condition = { { "cpp", "java", "python" }, { "backend", "frontend" }, { "junior", "senior" },
			{ "chicken", "pizza" } };
	static int count;

	public static void main(String[] args) {

		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

		System.out.println(Arrays.toString(solution(info, query)));
	}

	public static int[] solution(String[] info, String[] query) {
		
		int[] answer = new int[query.length];
		Map<String, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < info.length; i++) {
			String[] arr = info[i].split(" ");
			String key = arr[0] + arr[1] + arr[2] + arr[3];
			if (map.containsKey(key)) {
				map.get(key).add(Integer.parseInt(arr[4]));
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(Integer.parseInt(arr[4]));
				map.put(key, list);
			}
		}

		for (int i = 0; i < query.length; i++) {
			String[] s = new String[5];
			String[] tmp = query[i].split(" and ");
			for (int j = 0; j < 3; j++) {
				s[j] = tmp[j];
			}
			String[] tmp2 = tmp[3].split(" ");
			s[3] = tmp2[0];
			int score = Integer.parseInt(tmp2[1]);
			count = 0;
			makeKey(0, "", s, score, map);
			
			answer[i] = count;
		}

		return answer;
	}

	public static void makeKey(int cnt, String key, String[] s, int score, Map<String, List<Integer>> map) {
		if (cnt == 4) {
			if (map.containsKey(key)) {
				for (int i : map.get(key)) {
					if (i >= score)
						count++;
				}
			}

			return;
		}

		if (s[cnt].equals("-")) {
			for (int i = 0; i < condition[cnt].length; i++) {
				makeKey(cnt + 1, key + condition[cnt][i], s, score, map);
			}
		} else
			makeKey(cnt + 1, key + s[cnt], s, score, map);
	}
}