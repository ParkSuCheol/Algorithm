package July;

import java.util.*;

public class Solution_BJ_1991_트리의순회 {
	public static void main(String[] args) {
		input();
		pro();
	}

	static int N;
	static int[][] childs;
	static StringBuilder sb = new StringBuilder();
	static Scanner sc = new Scanner(System.in);

	public static void input() {
		N = sc.nextInt();
		childs = new int[30][2];
		for (int i = 0; i < N; i++) {
			char curCh = sc.next().charAt(0);
			int cur = (int) (curCh - 'A');
			for (int k = 0; k < 2; k++) {
				char ch = sc.next().charAt(0);
				if (ch != '.')
					childs[cur][k] = (int) (ch - 'A');
				else
					childs[cur][k] = -1;
			}
		}
	}
	
	public static void pro() {
		pre_order(0);
		sb.append('\n');
		in_order(0);
		sb.append('\n');
		post_order(0);
		System.out.println(sb);
	}
	
	public static void in_order(int x) {
		if (x == -1) return;
		in_order(childs[x][0]);
		sb.append((char)(x+'A'));
		in_order(childs[x][1]);
	}
	public static void pre_order(int x) {
		if (x == -1) return;
		sb.append((char)(x+'A'));
		pre_order(childs[x][0]);
		pre_order(childs[x][1]);
	}
	public static void post_order(int x) {
		if (x == -1) return;
		post_order(childs[x][0]);
		post_order(childs[x][1]);
		sb.append((char)(x+'A'));
	}
}
