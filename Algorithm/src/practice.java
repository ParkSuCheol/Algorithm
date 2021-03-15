import java.util.*;

public class practice {

	public static void main(String[] args) {
		int[] a = { 4, 3, 2, 1, };
		System.out.println(Arrays.toString(Solution(a)));
	}

	public static int[] Solution(int[] arr) {
		int[] answer = {};
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int c : arr)
			list.add(c);
		
		Integer min = Collections.min(list);
		list.remove(min);
		answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
