package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_BJ_∏‘¿ª∞Õ¿Œ∞°∏‘»˙∞Õ¿Œ∞°_practice {
	static int[] arr1,arr2;
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int B = sc.nextInt();
		for (int i = 0; i < B; i++) {
			int res = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			arr1 = new int[N+1];
			arr2 = new int[M+1];
			for (int j = 1; j <= N; j++) {
				arr1[j] = sc.nextInt();
			}
			for (int j = 1; j <= M; j++) {
				arr2[j] = sc.nextInt();
			}
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			for (int j = 1; j <= N; j++) {
				int left = arr1[j];
				int k = 1;
				int right = arr2[k];
				while(left > right) {
					res++;
					k++;
					if(k == M+1)
						break;
					right = arr2[k];
				}
			}
			System.out.println(res);
		}
	}
}
