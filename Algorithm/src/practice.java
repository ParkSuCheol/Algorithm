import java.util.*;
import java.io.*;
class practice {
	static int N;
	static ArrayList<Integer>[] arr;
	static int ans;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N+1];
		v = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		//¡÷ºÆ
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		pro();
		System.out.println(ans % 2 == 0 ? "No" : "Yes");
	}
	
	public static void pro() {
		ans = 0;
		dfs(1,0);
	}
	public static void dfs(int node, int cnt) {
		v[node] = true;
		for(int i : arr[node]) {
			if(!v[i]) {
				dfs(i,cnt+1);
			}
		}
		if(node != 1 && arr[node].size() == 1) {
			ans += cnt;
		}
	}
}