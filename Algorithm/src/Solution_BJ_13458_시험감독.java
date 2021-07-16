import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BJ_13458_시험감독 {
	static int N, A, B, C;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(solve());
	}

	private static long solve() {
		long count = 0;
		for (int i = 0; i < N; i++) {
			int sum = arr[i] - B;
			count++;
			
			if(sum <= 0)
				continue;
			if (sum % C == 0) {
				count += sum/C;
			}
			else{
				count += sum/C;
				count++;
			}
		}
		return count;
	}
}
