import java.util.*;
class practice {
	public static void main(String[] args){
		input();
		pro();
	}
	static Scanner sc = new Scanner(System.in);
	static int N,M;
	static ArrayList<Integer>[] list;
	static int[] indeg;
	public static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		indeg = new int[N+1];
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			int k = sc.nextInt();
			int[] tmp = new int[k];
			for (int j = 0; j < k; j++) {
				tmp[j] = sc.nextInt();
			}
			for (int j = 0; j < k-1; j++) {
				int a = tmp[j];
				int b = tmp[j+1];
				list[a].add(b);
				indeg[b]++;
			}
		}
	}
	public static void pro() {
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if(indeg[i] == 0)
				q.add(i);
		}
		while(!q.isEmpty()) {
			int x = q.poll();
			ans.add(x);
			for(int y : list[x]) {
				indeg[y]--;
				if(indeg[y] == 0)
					q.add(y);
			}
		}
		if(ans.size() != N) {
			ans.clear();
			ans.add(0);
		}
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
}