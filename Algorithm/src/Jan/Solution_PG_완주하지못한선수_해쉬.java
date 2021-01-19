package Jan;

import java.util.HashMap;

public class Solution_PG_완주하지못한선수_해쉬 {
	
		public static String solution(String[] participant, String[] completion) {
			String answer = "";
			HashMap<String,Integer> hm = new HashMap<>();
			for(String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
			for(String player : completion) hm.put(player, hm.get(player) - 1);
			
			for(String key : hm.keySet()) {
				if(hm.get(key) != 0)
					answer = key;
			}
			
			return answer;
		}
	
	public static void main(String[] args) {
		String[] participant = {"aa","bb","cc"};
		String[] completion = {"aa","bb"};
		
		System.out.println(solution(participant, completion));
	}

}
