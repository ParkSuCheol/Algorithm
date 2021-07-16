import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_BJ_14501_퇴사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] T = new int[N+10];
		int[] P = new int[N+10];
		int[] dp = new int[N+10];
		int max = 0;
		String[] str;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N+1; i++) {
			// 이전까지의 최대 수입을 비교해서 최대 수입을 현재에도 저장해준다
			// 이전에 최대 수입이 났을 수 있으므로
			// ex) 3,7,(5예상) 이라고 하면 5의 값은 7로 바꿔주는게 최대 수입을 얻는데 맞다
			dp[i] = Math.max(dp[i], max);
			// 이전에 저장된 최대수익 vs 이번 움직임으로 생긴 최대 수익
			dp[T[i]+i] = Math.max(dp[T[i]+i], P[i]+dp[i]);
			//출력 될 최대 수입
			max = Math.max(max, dp[i]);
			System.out.println(Arrays.toString(dp));
		}
		System.out.println(max);
	}
}	
