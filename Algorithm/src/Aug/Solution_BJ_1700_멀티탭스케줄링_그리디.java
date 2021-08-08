package Aug;

import java.util.*;

public class Solution_BJ_1700_멀티탭스케줄링_그리디 {
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
			if (!use[tmp]) { // 콘센트가 꽂혀있지 않은 경우
				if (Put < N) { // 콘센트를 꽂을 공간이 있을 경우
					use[tmp] = true;
					Put++;
				} else { // 콘센트를 꽂을 공간이 없는 경우
					ArrayList<Integer> list = new ArrayList<>();
					for (int j = i; j < K; j++) { // 현재 꽂혀 있는 콘센트가 나중에도 사용 되는지 확인
						if (use[order[j]] && !list.contains(order[j]))
							list.add(order[j]);
					}
					if (list.size() != N) { // 나중에도 사용되는 콘센트가 구멍의 개수보다 작을 경우
						for (int j = 0; j < use.length; j++) {
							if (use[j] && !list.contains(j)) {
								use[j] = false;
								break;
							}
						}
					} else { // 현재 꽂혀 있는 모든 콘센트가 나중에도 사용 될 경우
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
