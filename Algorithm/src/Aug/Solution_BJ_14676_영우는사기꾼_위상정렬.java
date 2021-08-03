package Aug;
import java.util.*;
public class Solution_BJ_14676_����»���_�������� {
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
				// x�� ���� �ǹ����� ��� ���������� Ȯ���ϱ�
				if(satisfaction[x] < indeg[x])
					abnormal = true;
				cnt[x]++;
				// x�� ó�� ���������̶�� x�� ������ �ִ� �ǹ��鿡 "������ ���� �ǹ� �� �ϳ��� ó�� ��������" ��� �˷��ֱ�
				if(cnt[x] == 1)
					for(int y: adj[x])
						satisfaction[y]++;
			}
			else {
				// x ��� �ǹ��� �Ѱ� �̻� �������ִ��� Ȯ���ϱ�
				if(cnt[x] == 0)
					abnormal = true;
				cnt[x]--;
				// x�� �� �̻� �������� �ʴٸ�, "������ ���� �ǹ� �� �ϳ��� �������" ��� �˷��ֱ�
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
