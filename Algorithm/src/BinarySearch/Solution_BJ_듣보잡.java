package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_BJ_µË∫∏¿‚ {
	static int N , M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		HashSet<String> hs = new HashSet<>();
		ArrayList<String> res = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			hs.add(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if(hs.contains(s)) {
				res.add(s);
			}
		}
		System.out.println(res.size());
		Collections.sort(res);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
