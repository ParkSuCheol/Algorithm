package July;

import java.io.*;

public class Solution_BJ_1110_더하기사이클 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int tmp = N;
		while(true) {
			N = ((N%10)*10) + (((N/10) + (N%10)) % 10);
			cnt ++;
			if(tmp == N)
				break;
		}
		System.out.println(cnt);
	}
}
