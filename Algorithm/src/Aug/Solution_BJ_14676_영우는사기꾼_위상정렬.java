package Aug;
import java.util.*;
public class Solution_BJ_14676_영우는사기꾼_위상정렬 {
	public static void main(String[] args) {
		input();
		pro();
	}
	static int N,M,K;
	static ArrayList<Integer>[] adj;
	static int[] indeg, cnt, satisfaction;
	static Scanner sc = new Scanner(System.in);
	public static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		adj = new ArrayList[N+1];
		indeg = new int[N+1];
		cnt = new int[N+1];
		satisfaction = new int[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a].add(b);
			indeg[b]++;
		}
	}
	public static void pro() {
		boolean abnormal = false;
		while(K-- > 0) {
			int t = sc.nextInt(), x = sc.nextInt();
			if( t == 1) {
				// x의 선행 건물들이 모두 지어졌는지 확인하기
				if(satisfaction[x] < indeg[x])
					abnormal = true;
				cnt[x]++;
				// x가 처음 지어진것이라면 x가 영향을 주는 건물들에 "너희의 선행 건물 중 하나가 처음 지어졌어" 라고 알려주기
				if(cnt[x] == 1)
					for(int y: adj[x])
						satisfaction[y]++;
			}
			else {
				// x 라는 건물이 한개 이상 지어져있는지 확인하기
				if(cnt[x] == 0)
					abnormal = true;
				cnt[x]--;
				// x가 더 이상 남아있지 않다면, "너희의 선행 건물 중 하나가 사라졌어" 라고 알려주기
				if(cnt[x] == 0)
					for(int y : adj[x])
						satisfaction[y]--;
			}
		}
		if(abnormal)
			System.out.println("Lier!");
		else
			System.out.println("King-God-Emperor");
	}
}
