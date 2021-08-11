package Aug;
import java.util.*;
public class Solution_BJ_1302_º£½ºÆ®¼¿·¯_ÇØ½¬¸Ê {
	public static void main(String[] args) {
		input();
	}
	static Scanner sc = new Scanner(System.in);
	static int N;
	static HashMap<String, Integer> map = new HashMap<String,Integer>();
	public static void input() {
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			if(map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			}
			else
				map.put(s, 1);
		}
		int max = 0;
		for(String a : map.keySet()) {
			max = Math.max(max,map.get(a));
		}
		ArrayList<String> a1 = new ArrayList<>(map.keySet());
		Collections.sort(a1);
		
		for(String a : a1) {
			if(map.get(a) == max) {
				System.out.println(a);
			}
		}
	}
}
