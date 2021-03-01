package Feb;

public class Solution_PG_2016 {

	public static void main(String[] args) {
		System.out.println(Solution(5,6).toString());
	}

	public static String Solution(int a,int b) {
		String answer = "";
		String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		String[] year = new String[366];
		int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
		int want_day = 0;
		
		for(int i = 0; i < year.length; i++) {
			year[i] = day[(i+5)%7];
		}
		
		for (int i = 0; i < a - 1; i++) {
			want_day += month[i];
		}
		
		want_day += b - 1;
		
		answer = year[want_day];
		
		return answer;
	}
}
