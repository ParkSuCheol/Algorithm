package July;
import java.util.*;
public class Solution_BJ_2644_촌수계산_dfs_list활용 {
	public static void main(String[] args) {
		input();
	}
	static ArrayList<Integer>[] list;
	static boolean[] v;
	static int N,Gx,Gy,M;
	static int res = -1;
	public static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Gx = sc.nextInt();
		Gy = sc.nextInt();
		M = sc.nextInt();
		list = new ArrayList[N+1];
		v = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		dfs(Gx,Gy,0);
		System.out.println(res);
	}
	public static void dfs(int start, int end, int cnt) {
		if(start == end) {
			res = cnt;
			return;
		}
		v[start] = true;
		for(int i : list[start]) {
			if(!v[i]) {
				dfs(i,end,cnt+1);
			}
		}
	}
}
