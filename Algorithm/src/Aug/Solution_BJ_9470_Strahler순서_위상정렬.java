package Aug;
import java.util.*;
public class Solution_BJ_9470_Strahler����_�������� {
	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			input();
			pro();
		}
	}
	static Scanner sc = new Scanner(System.in);
	static int K,N,M;
	static ArrayList<Integer>[] adj;
	static int[] indeg, order, maxCnt;
	public static void input() {
		K = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		adj = new ArrayList[N+1];
		indeg = new int[N+1];
		order = new int[N+1];
		maxCnt = new int[N+1];
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt(), y = sc.nextInt();
			adj[x].add(y);
			indeg[y]++;
		}
	}
	public static void pro() {
		Queue<Integer> q = new LinkedList<>();
		// ���� �տ� " ���� �� �� �ִ� " ���� ã��
		for(int i = 1; i <= N; i++) {
			if(indeg[i] == 0) {
				q.add(i);
				order[i] = maxCnt[i] = 1;
			}
		}
		// Strahler ������ ����ؼ� ���������� ��������.
		
		// ���� �� �� �ִ� ������ �ִٸ�?
		// 1. ���� ����� �߰��ϱ�
		// 2. ������ ����� ���� �����ϱ�
		// 3. ���Ӱ� " ���� �� �� �ִ�" ���� q �� �߰��ϱ�
		int ans = 0;
		while(!q.isEmpty()) {
			int x = q.poll();
			// ���� ������ ���� �� ���� ū ������ 2�� �̻��̸� �ڽ��� ������ 1 ������Ų��
			if(maxCnt[x] >= 2) order[x]++;
			ans = Math.max(ans, order[x]);
			for(int y:adj[x]) {
				indeg[y]--;
				if(indeg[y] == 0) q.add(y);
				// Stahler ���� ����� ���ؼ� y�� ������ ������ �ִ� ������ �������ش�
				if(order[y] == order[x]) maxCnt[y]++;
				else if (order[y] < order[x]) {
					order[y] = order[x];
					maxCnt[y] = 1;
				}
			}
		}
		System.out.println(K + " " + ans);
	}
}
