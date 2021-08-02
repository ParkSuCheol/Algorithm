package Aug;
import java.util.*;
public class Solution_BJ_1005_ACMũ����Ʈ_�������� {
	public static void main(String[] args) {
		int Q = sc.nextInt();
		while(Q > 0) {
			Q--;
			input();
			pro();
		}
	}

	static int N, M;
	// N ���� �л��� , �л����� Ű�� M�� ���Ѵ�.
	static Scanner sc = new Scanner(System.in);
	static LinkedList<Integer>[] list;
	static StringBuilder sb = new StringBuilder();
	static int[] indeg,T_done,T;
	public static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		list = new LinkedList[N + 1];
		indeg = new int[N+1];
		T = new int[N+1];
		T_done = new int[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<>();
			T[i] = sc.nextInt();
		}
		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			indeg[b]++;
		}
	}

	public static void pro() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0) {
				q.add(i);
				T_done[i] = T[i];
			}
		}
		
		// ���� �� �� �ִ� ������ �ִٸ�
		// 1. ���� ����� �߰��ϱ�
		// 2. ������ ����� ���� �����ϱ�
		// 3. ���Ӱ� "���� �� �� �ִ�" ����
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int y : list[x]) {
				indeg[y]--;
				if(indeg[y] == 0)
					q.add(y);
				T_done[y] = Math.max(T_done[y], T_done[x] + T[y]);
			}
		}
		int M = sc.nextInt();
		System.out.println(T_done[M]);
	}
}
