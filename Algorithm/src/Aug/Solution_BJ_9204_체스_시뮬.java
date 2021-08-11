package Aug;

import java.util.*;

public class Solution_BJ_9204_Ã¼½º_½Ã¹Ä {
	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			input();
			pro();
		}
	}

	static Scanner sc = new Scanner(System.in);
	static boolean[][] v;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, 1, -1 };
	static int sx, sy, ex, ey;

	public static void input() {
		v = new boolean[9][9];
		sy = sc.next().charAt(0) - 'A' + 1;
		sx = 9 - sc.nextInt();
		ey = sc.next().charAt(0) - 'A' + 1;
		ex = 9 - sc.nextInt();
	}

	public static void pro() {
		if (sx == ex && sy == ey) {
			System.out.println("0 " + (char) (sy + 'A' - 1) + " " + (9 - sx));
			return;
		} else if (Math.abs(sx - ex) + Math.abs(sy - ey) % 2 == 1) {
			System.out.println("Impossible");
			return;
		}
		first(ex, ey);
		if (v[sx][sy]) {
			System.out.print("1 ");
			System.out.print((char) (sy + 'A' - 1) + " " + (9 - sx) + " ");
			System.out.println((char) (ey + 'A' - 1) + " " + (9 - ex) + " ");
			return;
		}
		System.out.print("2 ");
		System.out.print((char) (sy + 'A' - 1) + " " + (9 - sx) + " ");
		second(sx, sy);
		System.out.println((char) (ey + 'A' - 1) + " " + (9 - ex) + " ");
	}

	public static void first(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x;
			int ny = y;
			while (true) {
				nx += dx[i];
				ny += dy[i];
				if (nx >= 1 && ny >= 1 && nx <= 8 && ny <= 8) {
					v[nx][ny] = true;
					continue;
				}
				break;
			}
		}
	}

	public static void second(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x;
			int ny = y;
			while (true) {
				nx += dx[i];
				ny += dy[i];
				if (nx >= 1 && ny >= 1 && nx <= 8 && ny <= 8) {
					if (v[nx][ny]) {
						System.out.print((char) (ny + 'A' - 1) + " " + (9 - nx) + " ");
						return;
					}
					continue;
				}
				break;
			}
		}
	}
}
