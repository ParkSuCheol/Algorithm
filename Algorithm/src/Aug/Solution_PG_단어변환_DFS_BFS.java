package Aug;

public class Solution_PG_단어변환_DFS_BFS {
	public static void main(String[] args) {
		String[] s = { "hot", "dot", "dog", "lot", "log", "cog" };
		solution("hit", "cog", s);
	}

	static boolean[] v;
	static int cnt;

	public static int solution(String begin, String target, String[] words) {
		v = new boolean[words.length + 1];
		cnt = Integer.MAX_VALUE;
		dfs(begin, target, words, 0, 0);
		if (cnt == Integer.MAX_VALUE)
			cnt = 0;
		return cnt;
	}

	public static void dfs(String begin, String target, String[] words, 
			int index, int chk) {

		if (begin.equals(target)) {
			cnt = Math.min(chk, cnt);
			return;
		}
		v[index] = true;
		chk++;
		for (int i = 0; i < words.length; i++) {
			int word = 0;
			for (int j = 0; j < begin.length(); j++) {
				if (begin.charAt(j) == words[i].charAt(j))
					word++;
			}
			if (word == begin.length() - 1 && !v[i + 1]) {
				dfs(words[i], target, words, i + 1, chk);
			}
		}
		v[index] = false;
		return;
	}
}
