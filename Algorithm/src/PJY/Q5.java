package PJY;

public class Q5 {
	public static void main(String[] args) {
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = { "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29",
				"01:37:44-02:02:30" };
		System.out.println(solution(play_time, adv_time, logs));
	}

	public static String solution(String play_time, String adv_time, String[] logs) {

		String[] tmp = play_time.split(":");
		int pt = Integer.parseInt(tmp[0]) * 3600 + Integer.parseInt(tmp[1]) * 60 + Integer.parseInt(tmp[2]);
		tmp = adv_time.split(":");
		int at = Integer.parseInt(tmp[0]) * 3600 + Integer.parseInt(tmp[1]) * 60 + Integer.parseInt(tmp[2]);

		int[] timeline = new int[pt];
		for (int i = 0; i < logs.length; i++) {
			String[] tmp2 = logs[i].split("-");
			tmp = tmp2[0].split(":");
			int s = Integer.parseInt(tmp[0]) * 3600 + Integer.parseInt(tmp[1]) * 60 + Integer.parseInt(tmp[2]);
			tmp = tmp2[1].split(":");
			int e = Integer.parseInt(tmp[0]) * 3600 + Integer.parseInt(tmp[1]) * 60 + Integer.parseInt(tmp[2]);

			for (int j = s; j < e; j++) {
				timeline[j]++;
			}
		}

		int l = 0, r = at, ans = 0;
		long max = 0, sum = 0;
		for (int i = 0; i < at; i++) {
			sum += timeline[i];
		}
		max = sum;
		while (true) {
			if (r == pt)
				break;
			sum -= timeline[l++];
			sum += timeline[r++];
			if (sum > max) {
				max = sum;
				ans = l;
			}
		}

		int h = ans / 3600, m = ans % 3600 / 60, s = ans % 3600 % 60;
		String answer = (h / 10 > 0 ? h : "0" + h) + ":" + (m / 10 > 0 ? m : "0" + m) + ":"
				+ (s / 10 > 0 ? s : "0" + s);
		return answer;
	}
}