package July;
import java.util.*;
public class Solution_BJ_1068_트리_단말노드 {
	public static void main(String[] args) {
		input();
		pro();
	}
	static int N, Del, Root;
	static ArrayList<Integer>[] list;
	static int[] leaf;
	public static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new ArrayList[N];
		leaf = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			if(a == -1) {
				Root = i;
				continue;
			}
			list[a].add(i);
		}
		Del = sc.nextInt();
	}
	public static void pro() {
		for (int i = 0; i < N; i++) {
			if(list[i].contains(Del)) {
				list[i].remove(list[i].indexOf(Del));
			}
		}
		if(Root != Del)
			dfs(Root);
		System.out.println(leaf[Root]);
	}
	public static void dfs(int start) {
		if(list[start].isEmpty()) {
			leaf[start] = 1;
		}
		for(int i: list[start]) {
			dfs(i);
			leaf[start] += leaf[i];
		}
	}
}
