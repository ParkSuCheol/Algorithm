package Aug;
import java.util.*;
public class Solution_BJ_2623_음악프로그램_위상정렬 {
	public static void main(String[] args) {
		input();
		pro();
	}
	static ArrayList<Integer>[] list;
	static int N,M;
	static int[] indeg;
	static Scanner sc = new Scanner(System.in);
	public static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		list = new ArrayList[N+1];
		indeg = new int[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int k = sc.nextInt();
			int[] arr = new int[k];
			for (int j = 0; j < k; j++) {
				arr[j] = sc.nextInt();
			}
			for (int j = 0; j < k - 1; j++) {
				int a = arr[j];
				int b = arr[j+1];
				list[a].add(b);
				indeg[b]++;
			}
		}
	}
	public static void pro() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if(indeg[i] == 0)
				q.add(i);
		}
		ArrayList<Integer> ans = new ArrayList<>();
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
		for(int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
}
