
import java.util.*;

class practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i < arr.length; i++) {
			while(!st.isEmpty() && arr[i] > arr[st.peek()]) {
				arr[st.pop()] = arr[i];
			}
			st.push(i);
		}
		
		while(!st.isEmpty()) {
			arr[st.pop()] = -1;
		}
		
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb.toString());
	}
}
