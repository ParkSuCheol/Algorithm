package May;

import java.util.*;

public class Solution_PG_KAKAO_¹æ±Ý±×°î {
	public static void main(String[] args) {
		String m = "CC#BCC#BCC#BCC#B";
		String[] ms = { "03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		System.out.println(solution(m,ms));
	}

	static String[] sharp = { "C#", "D#", "E#", "F#", "G#", "A#" };
	static String[] lowercase = { "c", "d", "e", "f", "g", "a" };

	public static String solution(String m, String[] musicinfos) {
		String melody = refine(m);
		String[][] infos = refine(musicinfos);
		
		Arrays.sort(infos,new Comparator<String[]>() {
			@Override
			public int compare(String[] music1, String[] music2) {
				int runningTimeOfMusic1 = Integer.parseInt(music1[0]);
				int runningTimeOfMusic2 = Integer.parseInt(music2[0]);
				
				return -(runningTimeOfMusic1 - runningTimeOfMusic2);
			}
		});
		
		for(int i = 0; i < infos.length; i++) {
			if(infos[i][2].contains(melody)) {
				return infos[i][1];
			}
		}
		
		return "(None)";
	}

	public static String refine(String m) {
		String result = m;
		for (int i = 0; i < sharp.length; i++) {
			result = result.replace(sharp[i], lowercase[i]);
		}
		return result;
	}

	public static String[][] refine(String[] musicinfos) {
		String[][] infos = new String[musicinfos.length][3];
		for (int i = 0; i < musicinfos.length; i++) {
			String[] info = musicinfos[i].split(",");
			String[] start = info[0].split(":");
			String[] end = info[1].split(":");
			String title = info[2];
			String code = info[3];
			String music = "";

			for (int j = 0; j < sharp.length; j++) {
				code = code.replace(sharp[j], lowercase[j]);
			}
			
			int musicLength = code.length();
			int runningTime = getRuuningTime(start,end);
			int codeIdx = 0;
			
			for(int j = 0; j < runningTime; j++) {
				music += code.charAt(codeIdx);
				codeIdx = (codeIdx + 1) % musicLength;
			}
			infos[i][0] = runningTime + "";
			infos[i][1] = title;
			infos[i][2] = music;
		}
		return infos;
	}

	public static int getRuuningTime(String[] start, String[] end) {
		int runningTime = 0;
		
		int startHour = Integer.parseInt(start[0]);
		int startMinute = Integer.parseInt(start[1]);
		int endHour = Integer.parseInt(end[0]);
		int endMinute = Integer.parseInt(end[1]);
		
		runningTime = (endHour - startHour) * 60 + (endMinute - startMinute);
		
		return runningTime;
	}

}
