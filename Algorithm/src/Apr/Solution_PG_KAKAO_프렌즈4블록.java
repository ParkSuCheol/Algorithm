package Apr;

public class Solution_PG_KAKAO_«¡∑ª¡Ó4∫Ì∑œ {
	public static void main(String[] args) {
		String[] s = { "AAAAAA", "BBAATB", "BBAATB", "JJJTAA", "JJJTAA" };
		System.out.println(solution(5, 6, s));
	}

	public static int solution(int m, int n, String[] board) {
		int answer = 0;
		char[][] map;
		boolean[][] v;
		map = new char[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}
		aa: while (true) {
			v = new boolean[m][n];
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					char c = map[i][j];
					if (c == '0')
						continue;
					if (c == map[i][j + 1] && c == map[i + 1][j] && c == map[i + 1][j + 1]) {
						v[i][j] = true;
						v[i][j + 1] = true;
						v[i + 1][j] = true;
						v[i + 1][j + 1] = true;
					}
				}
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (v[i][j]) {
						answer++;
						map[i][j] = '0';
					}
				}
			}

			for (int k = 0; k < m; k++) {
				for (int i = m - 1; i > 0; i--) {
					for (int j = 0; j < n; j++) {
						if (map[i][j] == '0') {
							map[i][j] = map[i - 1][j];
							map[i - 1][j] = '0';
						}
					}
				}
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (v[i][j]) {
						continue aa;
					}
				}
			}
			break;
		}
		return answer;
	}

	public static void print(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
