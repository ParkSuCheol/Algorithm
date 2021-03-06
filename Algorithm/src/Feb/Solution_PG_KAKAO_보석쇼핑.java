package Feb;

import java.util.*;

public class Solution_PG_KAKAO_보석쇼핑 {
	public static void main(String[] args) {
		String[] s = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		System.out.println(Arrays.toString(solution(s)));
	}
	
	static Queue<String> q = new LinkedList<String>();
    static HashSet<String> hs = new HashSet<String>(); 
    static HashMap<String, Integer> hm = new HashMap<String, Integer>();
    static int startPoint = 0;
    static int length = Integer.MAX_VALUE;
    
	public static int[] solution(String[] gems) {
        int[] answer = {};
        for(String g : gems) {
        	hs.add(g);
        }
        int start = 0;
        for (int i = 0; i < gems.length; i++) {
			// 배열을 돌면서 hashMap에 없다면 값을 추가해주고
        	// 있다면 개수를 하나 추가해준다
        	if(!hm.containsKey(gems[i]))
        		hm.put(gems[i], 1);
        	else
        		hm.put(gems[i], hm.get(gems[i])+1);
        	
        	// 큐에 보석을 담아준다.
        	q.add(gems[i]);
        	
        	//큐에 첫번쨰 보석의 개수가 1개를 초과한다면 startPoint 를 갱신해주고 q에서 빼준다
        	while(true) {
        		String temp = q.peek();
        		if(hm.get(temp) > 1) {
        			hm.put(temp, hm.get(temp) -1);
        			q.poll();
        			startPoint++;
        		}else {
        			break;
        		}
        	}
        	// 만약 현재 큐에 있는 보석이 모든 보석을 포함하고 hm의 크기와 hs의 크기가 같다면
        	// 새로구한 구간이 현재 구간의 길이보다 작다면 최종 시작포인트 값인 start를 갱신해준다
        	
        	if(hm.size() == hs.size() && length > q.size()) {
        		length = q.size();
        		start = startPoint;
        	}
        	
		}
        return new int[] {start+1,start+length};
    }
}
