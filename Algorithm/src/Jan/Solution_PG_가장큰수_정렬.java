package Jan;
import java.util.*;
public class Solution_PG_가장큰수_정렬 {
	public static String solution(int[] numbers) {
		String answer = "";
		
		String[] result = new String[numbers.length];
		
		for(int i=0; i<numbers.length; i++) {
			result[i] = String.valueOf(numbers[i]);
		}
		
		Comparator<String> comp = (o1,o2) -> (o2+o1).compareTo(o1+o2);
		Arrays.sort(result, comp);
		
		if(result[0].equals("0")) {
			return "0";
		}
		
		for(String a : result) {
			answer += a;
		}
		
		return answer;
	}
	public static void main(String[] args) {
		int[] arr1 = {6,10,2,4};
		int[] arr2 = {3,30,34,5,9};
		System.out.print(solution(arr1));
	}
}
