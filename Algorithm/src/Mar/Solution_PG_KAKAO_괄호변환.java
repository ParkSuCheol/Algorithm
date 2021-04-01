package Mar;

public class Solution_PG_KAKAO_°ýÈ£º¯È¯ {
	public static void main(String[] args) {
		String p = ")()()()(";
		System.out.println(solution(p));
	}

	static StringBuilder sb = new StringBuilder();

	public static String solution(String p) {
		return getValidateString(p);
	}

	public static int splitString(String p) {
		String[] splitString = p.split("");
		int count = 0;
		int index = 0;
		for (int i = 0; i < splitString.length; i++) {
			if (splitString[i].equals("("))
				count++;
			else
				count--;

			if (count == 0) {
				index = i + 1;
				break;
			}
		}
		return index;
	}

	public static boolean validateString(String p) {
		String[] split = p.split("");
		int count = 0;
		for (String s : split) {
			if (s.equals("("))
				count++;
			else
				count--;
			if (count < 0)
				return false;
		}
		return true;
	}

	public static String setValidateGrammer(String p) {
		String[] split = p.split("");
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < split.length - 1; i++) {
			if (split[i].equals("("))
				sb.append(")");
			else
				sb.append("(");
		}
		return sb.toString();
	}

	public static String getValidateString(String p) {
		int index = splitString(p);
		String u = p.substring(0, index);
		String v = p.substring(index);

		if (validateString(u))
			sb.append(u);
		else {
			sb.append("(");
			if (!v.equals("")) {
				getValidateString(v);
				v = "";
			}
			sb.append(")");
			sb.append(setValidateGrammer(u));
		}
		if (!v.equals("")) {
			getValidateString(v);
		}

		return sb.toString();
	}

}
