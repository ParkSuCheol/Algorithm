import java.util.*;

public class practice2 {
	public static void main(String[] args) {
		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		System.out.println(Arrays.toString(solution(s)));
	}

	public static int[] solution(String s) {
		int[] answer;
		
		s = s.substring(2,s.length()-2);
		s = s.replace("},{", "-");
		
		String[] arr = s.split("-");
		
		
		Arrays.sort(arr,(a,b) ->{
			return a.length() - b.length();
		});
		
		ArrayList<Integer> temp = new ArrayList<>();
		
		for(String c : arr) {
			String[] val = c.split(",");
			for(int i = 0; i < val.length; i++	) {
				int num = Integer.parseInt(val[i]);
				if(!temp.contains(num)) {
					temp.add(num);
				}
			}
		}
		
		answer = new int[temp.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = temp.get(i);
		}
		
		return answer;
	}
}
