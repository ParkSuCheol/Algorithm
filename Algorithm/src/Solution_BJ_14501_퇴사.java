import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_BJ_14501_��� {
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
			// ���������� �ִ� ������ ���ؼ� �ִ� ������ ���翡�� �������ش�
			// ������ �ִ� ������ ���� �� �����Ƿ�
			// ex) 3,7,(5����) �̶�� �ϸ� 5�� ���� 7�� �ٲ��ִ°� �ִ� ������ ��µ� �´�
			dp[i] = Math.max(dp[i], max);
			// ������ ����� �ִ���� vs �̹� ���������� ���� �ִ� ����
			dp[T[i]+i] = Math.max(dp[T[i]+i], P[i]+dp[i]);
			//��� �� �ִ� ����
			max = Math.max(max, dp[i]);
			System.out.println(Arrays.toString(dp));
		}
		System.out.println(max);
	}
}	
