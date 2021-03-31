package PJY;

public class qqq {
	public static void main(String[] args) {
		int[] timeline = { 1, 2, 3, 4, 3, 2, 1, 0, 1, 2, 3, 4, 3, 2, 1 };

		int pt = timeline.length, at = 5;
		int l = 0, r = 5, sum = 0, max = 0, ans = 0;
		for (int i = 0; i < at; i++) {
			sum += timeline[i];
		}
		max = sum;
		while (true) {
			System.out.println(sum);
			if (r == pt)
				break;
			if (sum > max) {
				max = sum;
				ans = l;
			}
			sum -= timeline[l++];
			sum += timeline[r++];
		}
		System.out.println(ans);
	}

}