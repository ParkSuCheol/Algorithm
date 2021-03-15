package Feb;

public class Solution_PG_이상한문자만들기 {
	public static void main(String[] args) {
		String s = "abc def gzd bvvcx";
		System.out.println(Solution(s).toString());
	}
	public static String Solution(String s) {
		String answer = "";
		int n = 0;
		String space =" ";
		String[] a = s.split("");
		for (int i = 0; i < a.length; i++) {
			if(a[i].equals(space)) {
				n = 0;
			}
			if(n % 2 == 0) {
				a[i] = a[i].toUpperCase();
				n++;
			}else {
				a[i] = a[i].toLowerCase();
				n++;
			}
			answer += a[i];
		}
		return answer;
	}
}
