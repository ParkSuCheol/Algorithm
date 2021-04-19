import java.util.ArrayList;

public class practice2 {
	public static void main(String[] args) {
		String s = "100-200*300-500+20";
		System.out.println(solution(s));
	}

	static long answer;
	static ArrayList<Character> ops = new ArrayList<>();
	static ArrayList<Long> nums = new ArrayList<>();
	static boolean[] check = new boolean[3];
	static char[] p = { '+', '-', '*' };

	public static long solution(String expression) {
		answer = 0;
		String s = "";
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c >= '0' && c <= '9') {
				s += c;
			} else {
				nums.add(Long.parseLong(s));
				ops.add(c);
				s = "";
			}
		}
		nums.add(Long.parseLong(s));

		dfs(0, new char[3]);

		return answer;
	}

	private static void dfs(int count, char[] cs) {
		if (count == 3) {
			ArrayList<Character> cops = new ArrayList<>(ops);
			ArrayList<Long> cnums = new ArrayList<>(nums);

			for (int i = 0; i < cs.length; i++) {
				for (int j = 0; j < cops.size(); j++) {
					if (cops.get(j) == cs[i]) {
						long ans = cal(cnums.remove(j), cnums.remove(j), cops.remove(j));
						cnums.add(j, ans);
						j--;
					}
				}
			}
			answer = Math.max(answer, Math.abs(cnums.get(0)));
		}

		for (int i = 0; i < 3; i++) {
			if (!check[i]) {
				check[i] = true;
				cs[count] = p[i];
				dfs(count + 1, cs);
				check[i] = false;
			}
		}
	}

	private static long cal(Long a, Long b, Character c) {
		long ans = 0;
		if (c == '+')
			ans = a + b;
		else if (c == '-')
			ans = a - b;
		else
			ans = a * b;
		return ans;
	}
}
