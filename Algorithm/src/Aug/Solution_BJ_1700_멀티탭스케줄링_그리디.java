package Aug;

import java.util.*;

public class Solution_BJ_1700_��Ƽ�ǽ����ٸ�_�׸��� {
	public static void main(String[] args) {
		input();
		pro();
	}

	static Scanner sc = new Scanner(System.in);
	static int N, K, Res, Put;
	static int[] order;
	static boolean[] use;

	public static void input() {
		N = sc.nextInt();
		K = sc.nextInt();
		order = new int[K];
		use = new boolean[101];
		for (int i = 0; i < K; i++) {
			order[i] = sc.nextInt();
		}
	}

	public static void pro() {
		Res = 0;
		Put = 0;
		for (int i = 0; i < K; i++) {
			int tmp = order[i];
			if (!use[tmp]) { // �ܼ�Ʈ�� �������� ���� ���
				if (Put < N) { // �ܼ�Ʈ�� ���� ������ ���� ���
					use[tmp] = true;
					Put++;
				} else { // �ܼ�Ʈ�� ���� ������ ���� ���
					ArrayList<Integer> list = new ArrayList<>();
					for (int j = i; j < K; j++) { // ���� ���� �ִ� �ܼ�Ʈ�� ���߿��� ��� �Ǵ��� Ȯ��
						if (use[order[j]] && !list.contains(order[j]))
							list.add(order[j]);
					}
					if (list.size() != N) { // ���߿��� ���Ǵ� �ܼ�Ʈ�� ������ �������� ���� ���
						for (int j = 0; j < use.length; j++) {
							if (use[j] && !list.contains(j)) {
								use[j] = false;
								break;
							}
						}
					} else { // ���� ���� �ִ� ��� �ܼ�Ʈ�� ���߿��� ��� �� ���
						int remove = list.get(list.size() - 1);
						use[remove] = false;
					}
					use[tmp] = true;
					Res++;
				}
			}
		}
		System.out.println(Res);
	}

}
