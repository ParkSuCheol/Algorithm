import java.util.*;

public class KAKAO_1 {
	public static void main(String[] args) {
		String[] id = { "muzi", "frodo", "apeach", "neo" };
		String[] re = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi", "apeach muzi" };
		solution(id, re, 2);
		String[] id2 = {"con", "ryan"};
		String[] re2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
//		solution(id2,re2,3);
	}

	public static int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		int[] new_Report = new int[id_list.length];
		String[][] re = new String[report.length][2];
		for (int i = 0; i < report.length; i++) {
			String[] tmp = report[i].split(" ");
			re[i][0] = tmp[0]; // 신고 한 사람
			re[i][1] = tmp[1]; // 신고 받은 사람
		}
		ArrayList<String> jail = new ArrayList<>(); // 감옥 간 사람
		for (int i = 0; i < id_list.length; i++) {
			Queue<String> cnt = new LinkedList<>();
			String s = id_list[i];
			for (int j = 0; j < report.length; j++) {
				if (s.equals(re[j][0])) {
					if (cnt.isEmpty())
						cnt.add(re[j][1]);
					else if (cnt.contains(re[j][1]))
						continue;
					else
						cnt.add(re[j][1]);
				}
			}
			System.out.println(cnt);
			int l = cnt.size();
			for (int j = 0; j < l; j++) {
				String temp = cnt.poll();
				for (int c = 0; c < new_Report.length; c++) {
					if (temp.equals(id_list[c]))
						new_Report[c]++;
				}
			}
			for (int j = 0; j < new_Report.length; j++) {
				if(jail.contains(id_list[j]))
					continue;
				if (new_Report[j] >= k) {
					jail.add(id_list[j]);
				}
			}
		}
		
		System.out.println(jail);
		
		for (int i = 0; i < report.length; i++) {
			if (jail.contains(re[i][1])) {
				for (int j = 0; j < id_list.length; j++) {
					if (re[i][0].equals(id_list[j]))
						answer[j]++;
				}
			}
		}
		return answer;
	}
}
