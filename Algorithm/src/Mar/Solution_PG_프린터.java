package Mar;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution_PG_«¡∏∞≈Õ {
	public static void main(String[] args) {
		int[] a = { 1, 1, 9, 1, 1, 1 };
		int b = 0;
		System.out.println(solution(a, b));
	}

	public static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int pri : priorities) {
        	q.add(pri);
        }
        
        while(!q.isEmpty()) {
        	for(int i = 0; i < priorities.length; i++) {
        		if(q.peek() == priorities[i]) {
        			q.poll();
        			answer++;
        			if(location == i) {
        				q.clear();
        				break;
        			}
        		}
        	}
        }
        
        return answer;
    }
}
