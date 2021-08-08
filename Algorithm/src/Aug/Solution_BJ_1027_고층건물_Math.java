package Aug;

import java.util.*;

public class Solution_BJ_1027_°íÃþ°Ç¹°_Math {
	public static void main(String[] args) {
		input();
	}

	static Scanner sc = new Scanner(System.in);
	static int N;
	static int[] building;
	static int[] visible;

	public static void input() {
		N = sc.nextInt();
		building = new int[N];
		visible = new int[N];
		for (int i = 0; i < N; i++) {
			building[i] = sc.nextInt();
		}
		count();
		System.out.println(Arrays.toString(visible));
		Arrays.sort(visible);
		System.out.println(visible[visible.length-1]);
	}

	public static void count() {
		for (int i = 0; i < N - 1; i++) {
			visible[i] += 1;
			visible[i + 1] += 1;
			double slope = building[i + 1] - building[i];
			for (int j = i + 1; j < N; j++) {
				double nextSlope = (double) (building[j] - building[i]) / (j - i);
				if (nextSlope <= slope)
					continue;
				slope = nextSlope;
				visible[i]++;
				visible[j]++;
			}
		}
	}
}
