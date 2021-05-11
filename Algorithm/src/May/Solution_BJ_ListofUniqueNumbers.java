package May;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_BJ_ListofUniqueNumbers {
	static int[] cnt,arr;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		cnt = new int[100000+1];
		
		pro();
	}

	private static void pro() {
		long ans = 0;
		for(int L = 1, R = 0; L <= N; L++) { // L ���� R�� �ִ��� �Ű� �� ��ȹ�̴�
			// R �� �ű� �� �ִ� ��ŭ �ű��.
			while(R+1 <= N && cnt[arr[R+1]]==0) {
				R++;
				cnt[arr[R]]++;
			}
			// ������ �����Ѵ�
			ans += R - L + 1;
			
			// L �� �Ű��ָ鼭 arr[L] �� ������ ���ҽ�Ų��
			cnt[arr[L]]--;
		}
		System.out.println(ans);
	}
}
