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
		for(int L = 1, R = 0; L <= N; L++) { // L 마다 R을 최대한 옮겨 줄 계획이다
			// R 을 옮길 수 있는 만큼 옮긴다.
			while(R+1 <= N && cnt[arr[R+1]]==0) {
				R++;
				cnt[arr[R]]++;
			}
			// 정답을 갱신한다
			ans += R - L + 1;
			
			// L 을 옮겨주면서 arr[L] 의 개수를 감소시킨다
			cnt[arr[L]]--;
		}
		System.out.println(ans);
	}
}
