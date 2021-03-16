import java.util.*;

public class practice {

	public static void main(String[] args) {
		int[] numbers = {1,3,4,5,8,2,1,4,5,9,5};
		System.out.println((Solution(numbers,"right")));
	}

	public static String Solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();
		int leftNum = 10;
		int rightNum = 12;
		for(int number : numbers) {
			if(number == 1 || number == 4 || number == 7) {
				sb.append("L");
				leftNum = number;
			}else if (number == 3 || number == 6 || number == 9){
				sb.append("R");
				rightNum = number;
			}else {
				int leftLength = Length(leftNum, number);
				int rightLength = Length(rightNum, number);
				if(leftLength > rightLength) {
					sb.append("R");
					rightNum = number;
				}else if (leftLength < rightLength) {
					sb.append("L");
					leftNum = number;
				}else {
					if(hand.equals("right")) {
						sb.append("R");
						rightNum = number;
					}else {
						sb.append("L");
						leftNum = number;
					}
				}
			}
		}
		return sb.toString();
	}

	private static int Length(int Index, int number) {
		if(Index == 0)
			Index = 11;
		if(number == 0)
			number = 11;
		
		int Lx = (Index-1) / 3;
		int Ly = (Index-1) % 3;
		int x = number / 3;
		int y = 1;
		
		return Math.abs(Ly-y) + Math.abs(Lx - x);
	}

}