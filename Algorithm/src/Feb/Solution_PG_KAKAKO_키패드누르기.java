package Feb;


public class Solution_PG_KAKAKO_키패드누르기 {
	public static void main(String[] args) {
		int[] numbers = {1,3,4,5,8,2,1,4,5,9,5};
		System.out.println((Solution(numbers,"right")));
	}
	public static String Solution(int[] numbers, String hand) {
		int leftIndex = 10;
		int rightIndex = 10;
		StringBuilder sb = new StringBuilder();
		for(int number: numbers) {
			if(number == 1 || number == 4 || number == 7) {
				sb.append("L");
				leftIndex = number;
			}else if(number == 3 || number == 6 || number == 9) {
				sb.append("R");
				rightIndex = number;
			}else {
				int leftLength = getLength(leftIndex,number);
				int rightLength = getLength(rightIndex,number);
				if(leftLength > rightLength) {
					sb.append("R");
					rightIndex = number;
				}else if(leftLength < rightLength) {
					sb.append("L");
					leftIndex = number;
				}else {
					if(hand.equals("right")) {
						sb.append("R");
						rightIndex = number;
					}else {
						sb.append("L");
						leftIndex = number;
					}
				}
			}
		}
		
		return sb.toString();
	}
	private static int getLength(int index, int number) {
		if(index == 0)
			index = 11;
		if(number == 0)
			number = 11;
		
		int x = (index -1)/3;
		int y = (index -1)%3;
		int NumberX = number / 3;
		int NumberY = 1;
		
		return Math.abs(x-NumberX) + Math.abs(y-NumberY);
	}
}
