import java.util.*;
class practice {
	public static void main(String[] args){
		input();
		pro();
	}
	static Scanner sc = new Scanner(System.in);
	static int N,M;
	static ArrayList<Integer>[] list;
	static int[] dy;
	static StringBuilder sb = new StringBuilder();
	public static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		list = new ArrayList[N+1];
		dy = new int[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			int x = sc.nextInt();
			if(i == 1) continue;
			list[x].add(i);
		}
		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			dy[a] += b;
		}
	}
	public static void pro() {
		dfs(1);
		for (int i = 1; i <= N; i++) {
			sb.append(dy[i]).append(' ');
		}
		System.out.println(sb);
	}
	public static void dfs(int x) {
		for(int y : list[x]) {
			dy[y] += dy[x];
			dfs(y);
		}
	}
}