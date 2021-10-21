import java.util.*;

public class Fasoo_1 {

	public static void main(String[] args) {
		int[][] b = { { 2, 0 }, { 4, 0 }, { 1, 4 }, { -1, -4 } };
		solution(b);
	}

	public static int solution(int[][] balloons) {
		int answer = 0;
		HashSet<Double> res = new HashSet<>();
		int cnt = 0;
		boolean chk = false;
		for (int i = 0; i < balloons.length; i++) {
			if (balloons[i][1] == 0) {
				res.add((double) 0.0);
				continue;
			} else if (balloons[i][0] == 0)
				chk = true;
			else {
				double avg = (double) balloons[i][0] / (double) balloons[i][1];

				if (balloons[i][0] > 0) {
					if (balloons[i][1] > 0) {
						res.add(avg);
						continue;
					} else {
						res.add(avg);
						continue;
					}
				} else {
					if (balloons[i][1] > 0) {
						if(res.contains(avg)) {
							cnt++;
							continue;
						}
					}else {
						if(res.contains(avg)) {
							cnt++;
							continue;
						}
					}
				}
				
			}
		}
		if (chk)
			answer = res.size() + 1 + cnt;
		else
			answer = res.size() + cnt;

		System.out.println(res);

		System.out.println(answer);

		return answer;
	}
}
