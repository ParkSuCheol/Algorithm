package Feb;

public class Solution_PG_���ڼ��ڼ��ڼ��� {
	public static void main(String[] args) {
		Solution(7);
	}
	
	public static String Solution(int n) {
		String answer="";
		StringBuilder arr = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if(i % 2 == 0)
//				arr.append("��");
				answer += "��";
			else
//				arr.append("��");
				answer += "��";
		}
//		answer = arr.toString();
		return answer;
	}
}
