package July;
import java.util.*;
public class Solution_BJ_11725_트리의부모찾기 {
	public static void main(String[] args) {
		input();
		pro();
	}
	static int N;
	static List<Integer>[] list;
	static int[] parents;
	static boolean[] v;
	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new ArrayList[N+1];
		parents = new int[N+1];
		v = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
	}
	public static void pro() {
		dfs(1);
		for (int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
	}
	public static void dfs(int start) {
		v[start] = true;
		
		for (int i : list[start]) {
			if(!v[i]) {
				parents[i] = start;
				dfs(i);
			}
		}
	}
}
