package Dec;

import java.util.Scanner;

public class Solution_BJ_14719_ºø¹° {
	static int[] Array;
	static int Result;
	static int Left, Right;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Array = new int[M];
		
		for (int i = 0; i < M; i++) {
			Array[i] = sc.nextInt();
		}
		for (int i = 1; i < M - 1; i++) {
			Left = Right = 0;
			for (int j = 0; j < i; j++) {
				Left = Math.max(Array[j], Left);
			}
			for (int j = i + 1; j < M; j++) {
				Right = Math.max(Array[j], Right);
			}
			if (Right > Array[i] && Left > Array[i]) {
				Result += Math.min(Left, Right) - Array[i];
			}
		}
		System.out.println(Result);
	}
}
