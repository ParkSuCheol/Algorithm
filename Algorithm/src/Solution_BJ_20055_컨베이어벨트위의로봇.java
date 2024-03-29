import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BJ_20055_컨베이어벨트위의로봇 {
	static int n, k, map[], left, right;
	static boolean robot[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[2 * n];
		robot = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * n; i++)
			map[i] = Integer.parseInt(st.nextToken());
		left = 0;
		right = n;
		int count = 0;
		while (k > 0) {
			count++;
			moveBelt();
			moveRobot();
			newRobot();
		}
		
		System.out.println(count);
	}

	private static void moveBelt() {
		left--;
		right--;
		if (left == -1)
			left = 2 * n - 1;
		if (right == -1)
			right = 2 * n - 1;

		for (int i = n - 2; i >= 0; i--) {
			if (robot[i]) {
				robot[i] = false;
				if (i + 1 < n - 1)
					robot[i + 1] = true;
			}
		}
	}

	private static void moveRobot() {
		for(int i = n-2; i >= 0; i--) {
			if(robot[i]) {
				int next = left + i + 1;
				if(next >= 2*n)
					next -= 2*n;
				if(!robot[i+1] && map[next] >= 1) {
					robot[i] = false;
					if(i+1 < n-1)
						robot[i+1] = true;
					map[next]--;
					if(map[next] == 0)
						k--;
				}
			}
		}
	}
	

	private static void newRobot() {
		if(!robot[0] && map[left] > 0) {
			robot[0] = true;
			map[left]--;
			if(map[left] == 0)
				k--;
		}
	}


}
