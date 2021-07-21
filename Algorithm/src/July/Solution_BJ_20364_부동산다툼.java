package July;
import java.util.*;
public class Solution_BJ_20364_부동산다툼 {
	public static void main(String[] args) {
		input();
	}
	static int N ,Q;
	static int[] arr;
	public static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Q = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		arr = new int[Q];
		for (int i = 0; i < Q; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < Q; i++) {
			int cur = arr[i];
			int t = cur;
			int temp = 0;
			while(true) {
				if(t==0) break;
				if(set.contains(t)) temp = t;
				t/=2;
			}
			System.out.println(temp);
			if(temp == 0) 
				set.add(cur);
		}
	}
}
