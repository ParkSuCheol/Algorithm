package Mar;

import java.util.Scanner;

public class Solution_BJ_N°úM2 {
	static int n, r;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		arr = new int[r];
		permutation(0,0);
	}

	public static void permutation(int at,int Idx) {
		if (Idx == r) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = at; i < n; i++) {
			arr[Idx] = i + 1;
			permutation(i + 1, Idx + 1);
		}
	}
}
