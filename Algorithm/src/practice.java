import java.util.*;
class practice{
	public static void main(String[] args) {
		input();
	}
	static int N;
	static List<Integer>[] rel;
	static int res = -1;
	static boolean[] v;
	public static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		rel = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			rel[i] = new ArrayList<>();
		}
		v = new boolean[N+1];
		int x = sc.nextInt();
		int y = sc.nextInt();
		int l = sc.nextInt();
		for (int i = 0; i < l; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			rel[a].add(b);
			rel[b].add(a);
		}
		dfs(x,y,0);
		System.out.println(res);
	}
	
	public static void dfs(int start, int end, int cnt) {
		if(start == end) {
			res = cnt;
			return;
		}
		v[start] = true;
		for(int i : rel[start]) {
			if(!v[i]) {
				dfs(i,end,cnt+1);
			}
		}
		
	}
	
}