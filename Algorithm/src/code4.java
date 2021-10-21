import java.util.*;
public class code4 {
	public static void main(String[] args) {
		int[] A = {3,1,2};
		int[] B = {2,3,1};
		solution(A,B);
	}
	public static int N;
	public static boolean[] v;
	public static boolean[] visit;
	public static boolean[] recur;
	public static ArrayList<Integer>[] adj;
	public static boolean solution(int[] A, int[] B) {
		boolean answer = true;
		N = A.length;
		System.out.println(N);
		adj = new ArrayList[N+1];
		v = new boolean[N+1];
		visit = new boolean[N+1];
		recur = new boolean[N+1];
		for(int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N; i++) {
			adj[A[i]].add(B[i]);
		}
		int ans = 0;
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			if(dfs(i)) ans++;
			if(dfss(i)) cnt++;
		}
		System.out.println(ans);
		System.out.println(cnt);
		return answer;
    }
	
	public static boolean dfs(int x) {
		if(v[x]) return false;
		v[x] = true;
		for(int value:adj[x]) {
			if(!v[value])
				dfs(value);
		}
		return true;
	}
	
	public static boolean dfss(int x) {
		visit[x] = true;
		recur[x] = true;
		for(int value : adj[x]) {
			int b = value;
			if(!visit[b] && dfs(b)) {
				return true;
			}
			else if (recur[b]) {
				return true;
			}
			recur[x] = false;
			return false;
		}
		return false;
	}
	
}
