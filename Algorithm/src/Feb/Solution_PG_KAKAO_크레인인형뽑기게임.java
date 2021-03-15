package Feb;

import java.util.*;

public class Solution_PG_KAKAO_크레인인형뽑기게임 {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(Solution(board, moves));
//		Solution(board,moves);
	}

	public static int Solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 0; i < moves.length; i++) {
			int N = moves[i] - 1;
			for (int j = 0; j < board[0].length; j++) {
				if(board[j][N] != 0) {
					int num = board[j][N];
					if(stack.peek() == num) {
						stack.pop();
						answer+=2;
					}else {
						stack.push(num);
					}
					board[j][N] = 0;
					break;
				}
			}
		}
		return answer;
	}
}
