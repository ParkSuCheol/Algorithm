package Mar;

import java.util.*;

public class Solution_PG_KAKAO_ÈÄº¸Å° {
	public static void main(String[] args) {
		String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
//		System.out.println(solution(relation));
		solution(relation);
	}

	static ArrayList<HashSet<Integer>> candidateKey;
	static String Table[][];
	static int length;
	static int answer;

	public static int solution(String[][] relation) {
		answer = 0;
		candidateKey = new ArrayList<HashSet<Integer>>();
		Table = relation;
		length = relation[0].length;
		for (int i = 1; i <= length; i++) {
			makeSet(-1, i, 0, new HashSet<Integer>());
		}
		return answer;
	}

	public static void makeSet(int index, int count, int dept, HashSet<Integer> set) {

		if (dept == count) {
			if (!isUnique(set)) {
				return;
			}
			for (HashSet<Integer> key : candidateKey) {
				if (set.containsAll(key))
					return;
			}
			candidateKey.add(set);
//			System.out.println(set);
			answer++;
			return;
		}

		for (int i = index + 1; i < length; i++) {
			HashSet<Integer> newSet = new HashSet<Integer>(set);
			newSet.add(i);
			makeSet(i, count, dept + 1, newSet);
		}
	}

	private static boolean isUnique(HashSet<Integer> set) {

		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < Table.length; i++) {
			String temp = "";
			for (int index : set) {
				temp += Table[i][index];
			}
			if (!list.contains(temp)) {
				list.add(temp);
			} else {
				return false;
			}
		}
		return true;
	}
}
