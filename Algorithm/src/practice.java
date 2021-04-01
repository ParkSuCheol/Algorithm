
public class practice {

	public static void main(String[] args) {
		String p = ")()()()(";
		System.out.println(solution(p));
		getValidateString(p);
	}

	static StringBuilder sb = new StringBuilder();

	public static String solution(String p) {
		return getValidateString(p);
	}

	public static int getIndx(String p) {
		String[] s = p.split("");
		int index = 0;
		int start = 0;
		for (int i = 0; i < p.length(); i++) {
			if(s[i].equals("("))
				start++;
			else
				start--;
			if(start == 0) {
				index = i + 1;
				break;
			}
		}
		return index;
	}
	
	public static boolean chkTrue(String p) {
		String[] s = p.split("");
		int count = 0;
		for (String c : s) {
			if(c.equals("("))
				count++;
			else
				count--;
			if(count < 0)
				return false;
		}
		return true;
	}
	
	private static void reverseString(String p) {
		p = p.substring(1, p.length()-1);
		for (int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == '(')
				sb.append(")");
			else
				sb.append("(");
		}
	}
	
	public static String getValidateString(String p) {
		int index = getIndx(p);
		String u = p.substring(0,index);
		String v = p.substring(index);
		
		if(chkTrue(u)) {
			sb.append(u);
		}else {
			sb.append("(");
			if(!v.equals("")) {
				getValidateString(v);
				v = "";
			}
			sb.append(")");
			reverseString(u);
		}
		if (!v.equals("")) {
			getValidateString(v);
		}
		
		return sb.toString();
	}

}