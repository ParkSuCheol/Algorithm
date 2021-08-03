package Aug;
import java.util.*;
public class Solution_BJ_14267_회사문화_트리 {
	public static void main(String[] args) {
		input();
		pro();
	}
	static int N, M;
	static int[] Dy;
	static ArrayList<Integer>[] children;
	static StringBuilder sb = new StringBuilder();
	static Scanner sc = new Scanner(System.in);
	public static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		Dy = new int[N+1];
		children = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			children[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			int par = sc.nextInt();
			if( i == 1) continue;
			children[par].add(i);
		}
		for (int i = 1; i <= M; i++) {
			int x = sc.nextInt();
			int v = sc.nextInt();
			Dy[x] += v;
		}
	}
	public static void pro() {
		dfs(1);
		for (int i = 1; i <= N; i++) {
			sb.append(Dy[i]).append(' ');
		}
		System.out.println(sb);
	}
	public static void dfs(int x) {
		for(int y : children[x]) {
			Dy[y] += Dy[x];
			dfs(y);
		}
	}
}
