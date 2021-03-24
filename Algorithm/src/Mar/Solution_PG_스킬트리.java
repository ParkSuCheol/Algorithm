package Mar;

public class Solution_PG_스킬트리 {
	public static void main(String[] args) {
		String a = "CBD";
		String[] tre = { "CAD"};
		solution(a, tre);
	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (int i = 0; i < skill_trees.length; i++) {
			System.out.println(skill_trees[i]);
			int[] chk = new int[skill.length()];
			boolean v = false;
			for (int j = 0; j < skill.length(); j++) {
				char c = skill.charAt(j);
				chk[j] =Integer.MAX_VALUE;
				for (int k = 0; k < skill_trees[i].length(); k++) {
					if (c == skill_trees[i].charAt(k)) {
						chk[j] = k;
						System.out.print(c + " : " + k);
						break;
					}
				}
				System.out.println();
				if (j > 0 && chk[j] < chk[j - 1]) {
					v = false;
					break;
				}
				v = true;
			}
			if (v) {
				answer++;
			}
		}
		System.out.println(answer);
		return answer;
	}
}
