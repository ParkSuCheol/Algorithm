package Mar;

import java.util.*;

public class solution_PG_KAKAO_순위검색 {
	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		solution(info, query);
	}

	static HashMap<String, ArrayList<Integer>> map = new HashMap<>();

	public static int[] solution(String[] info, String[] query) {
		int[] answer = {};
		answer = new int[query.length];
		
		int start = 0;
		
		for (int i = 0; i < info.length; i++) {
			String[] t = info[i].split(" ");
			String str = "";
			str += t[0]+t[1]+t[2]+t[3];
			int score = Integer.valueOf(t[4]);
			dfs(0,"",t,score);
		}
		
		for(String key:map.keySet()) {
			ArrayList<Integer> tmp = map.get(key);
			Collections.sort(tmp);
		}
		
		for (int i = 0; i < query.length; i++) {
			String query_str = "";
			String[] t = query[i].split(" ");
			
			for (int j = 0; j < t.length-1; j++) {
				if(t[j].equals("and")) {
					continue;
				}
				query_str += t[j];
			}
			System.out.println(query_str);
			int score = Integer.valueOf(t[t.length-1]);
			if(map.containsKey(query_str)) {
				ArrayList<Integer> tmp = map.get(query_str);
				int num = loewr_bound(tmp,score);
				answer[i] = num;
			}
		}
		return answer;
	}

	private static int loewr_bound(ArrayList<Integer> list, int score) {
		int start = 0;
		int end = list.size();
		while(start < end) {
			int mid = (start+end)/2;
			if(list.get(mid) >= score) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
		
		return list.size()-end;
	}

	public static void dfs(int dept, String tmp, String[] str, int score) {
		if (dept == 4) {
			ArrayList<Integer> list = new ArrayList<>();
			if (map.containsKey(tmp)) {
				list = map.get(tmp);
			}
			list.add(score);
			map.put(tmp, list);
			return;
		}
		dfs(dept + 1, tmp + str[dept], str, score);
		dfs(dept + 1, tmp + "-", str, score);
	}
}
