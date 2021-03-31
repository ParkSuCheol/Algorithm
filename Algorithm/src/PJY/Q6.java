package PJY;

import java.awt.Point;
import java.util.*;

public class Q6 {

	static List<Card> list;
	static int cnt, R, C, min;
	static int[] di = { -1, 0, 1, 0 }, dj = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		int[][] board = { { 1, 4, 0, 3 }, { 2, 0, 5, 4 }, { 0, 0, 0, 2 }, { 3, 5, 1, 0 } };
		int r = 1;
		int c = 0;

		System.out.println(solution(board, r, c));
	}

	public static int solution(int[][] board, int r, int c) {
		int answer = 0;

		list = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] != 0) {
					list.add(new Card(i, j, board[i][j]));
				}
			}
		}

		int n = list.size() / 2;
		Collections.sort(list, (o1, o2) -> o1.c - o2.c);

		int[] card = new int[n];
		boolean[] used = new boolean[n];
		R = r;
		C = c;
		min = Integer.MAX_VALUE;
		setCard(0, n, card, used);

		answer = min + n * 2;
		return answer;
	}

	static int find(int r, int c, Card goal, boolean[] isChecked) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		int cnt = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				if (p.x == goal.i && p.y == goal.j) {
					return cnt;
				}
				for (int k = 0; k < 4; k++) {
					int ti = p.x + di[k], tj = p.y + dj[k];
					if (ti < 0 || tj < 0 || ti == 4 || tj == 4)
						continue;
					q.add(new Point(ti, tj));
				}
				for (int k = 0; k < 4; k++) {
					int ti = p.x + di[k], tj = p.y + dj[k];
					if (ti < 0 || tj < 0 || ti == 4 || tj == 4)
						continue;
					boolean isOk = true;
					while (true) {
						if (ti == goal.i && tj == goal.j) {
							return cnt + 1;
						}
						for (int j = 0; j < list.size(); j++) {
							if (isChecked[j])
								continue;
							if (ti == list.get(j).i && tj == list.get(j).j) {
								isOk = false;
								break;
							}
						}
						if (!isOk || ti + di[k] < 0 || tj + dj[k] < 0 || ti + di[k] >= 4 || tj + dj[k] >= 4)
							break;
						ti += di[k];
						tj += dj[k];
					}
					if (p.x + di[k] == ti && p.y + dj[k] == tj)
						continue;
					q.add(new Point(ti, tj));
				}
			}
			cnt++;
		}
		return 0;
	}

	static void start(int[] result) {
		boolean[] isChecked = new boolean[result.length];
		int cnt = find(R, C, list.get(result[0]), isChecked);

		for (int i = 1; i < result.length; i++) {
			cnt += find(list.get(result[i - 1]).i, list.get(result[i - 1]).j, list.get(result[i]), isChecked);
			if (i % 2 == 1) {
				isChecked[result[i - 1]] = true;
				isChecked[result[i]] = true;
			}
		}
		min = Math.min(min, cnt);
	}

	static void setLoc(int cnt, int n, int[] card, int[] result, boolean[] used) {
		if (cnt == n) {
			start(result);
			return;
		}

		for (int i = 0; i < 2; i++) {
			int k = card[cnt / 2] * 2 + i;
			if (!used[k]) {
				result[cnt] = k;

				used[k] = true;
				setLoc(cnt + 1, n, card, result, used);
				used[k] = false;
			}
		}
	}

	static void setCard(int cnt, int n, int[] card, boolean[] used) {
		if (cnt == n) {
			setLoc(0, 2 * n, card, new int[2 * n], new boolean[2 * n]);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!used[i]) {
				card[cnt] = i;

				used[i] = true;
				setCard(cnt + 1, n, card, used);
				used[i] = false;
			}
		}
	}

	static class Card {
		int i, j, c;

		public Card(int i, int j, int c) {
			this.i = i;
			this.j = j;
			this.c = c;
		}

	}
}