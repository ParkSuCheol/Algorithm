package May;
import java.util.*;
public class Solution_PG_KAKAO_æ–√‡ {
	public static void main(String[] args) {
		String s = "ABABABAB";
		System.out.println(Arrays.toString(solution(s)));
	}
	public static int[] solution(String msg) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<String,Integer> hs = new HashMap<String,Integer>();
        int ind = 1;
        for(char i = 'A'; i <= 'Z'; i++) {
        	hs.put(i+"", ind++);
        }
        int size = msg.length();
        for(int i = 0; i < size; i++) {
        	int a = 1;
        	while(i+a <= size && hs.containsKey(msg.substring(i,i+a))) {
        		a++;
        	}
        	if(i + a > size) {
        		ans.add(hs.get(msg.substring(i)));
        		break;
        	}
        	ans.add(hs.get(msg.substring(i,i+a-1)));
        	hs.put(msg.substring(i,i+a), ind++);
        	if(a > 1)
        		i += a-2;
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = ans.get(i);
		}
        return answer;
    }
}
