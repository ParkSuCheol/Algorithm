package Sep;
import java.util.*;
public class Solution_PG_추석트래픽 {
	public static void main(String[] args) {
		String[] s = {"2016-09-15 01:00:04.002 2.0s","2016-09-15 01:00:07.000 2s"};
		
		System.out.println(solution(s));
	}
	public static class Process{
		String date;
		float start;
		float end;
		public Process(String date, float start, float end) {
			this.date = date;
			this.start = start;
			this.end = end;
		}
	}
	
	public static int solution(String[] lines) {
		int answer = 0;
		ArrayList<Process> list = new ArrayList<>();
		for(String line : lines) {
			line = line.replace("s", ""); // 처리 속도를 전부 숫자 형태로 바꿔줌
			String[] str = line.split(" ");
			String date = str[0];
			String[] time = str[1].split(":");
			float end = (Float.parseFloat(time[0])*3600) + (Float.parseFloat(time[1])*60)
					+ Float.parseFloat(time[2]);
			
			float start = (end - Float.parseFloat(str[2])) + (float)0.001;
			list.add(new Process(date,start,end));
		}
		
		for(int i = 0, outter = list.size(); i < outter; i++) {
			Process cur = list.get(i);
			float range = cur.end+(float)0.999;
			int cnt = 0;
			for(int j = i, inner = list.size(); j < inner; j++) {
				Process next = list.get(j);
				
				if(range >= next.start) cnt++;
			}
			answer = Math.max(cnt,answer);
		}
		return answer;
	}
}
