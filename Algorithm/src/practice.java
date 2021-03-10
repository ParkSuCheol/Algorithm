import java.util.*;

public class practice {

	public static void main(String[] args) {
		String[] a = {"sun","bed","car"};
		System.out.println(Arrays.toString(Solution(a,1)));
	}
	
	public static String[] Solution(String[] strings, int n) {
		String[] answer = {};
		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < strings.length; i++) {
			arr.add(strings[i].charAt(n) + strings[i]);
		}
		Collections.sort(arr);
		answer = new String[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			answer[i] = arr.get(i).substring(1,arr.get(i).length());
		}
		return answer;
	}
}
