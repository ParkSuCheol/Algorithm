package Mar;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_PG_다리를지나는트럭 {
	public static void main(String[] args) {
		int[] a = {7,4,5,6};
		System.out.println(solution(2,10,a));
	}
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        
        int max = 0;
        for(int w : truck_weights) {
        	
        	while(true) {
        		if(q.isEmpty()) {
        			q.offer(w);
        			max += w;
        			answer++;
        			break;
        		}else if (q.size() == bridge_length) {
        			max -= q.poll();
        			System.out.println(max);
        		}else {
        			if(max + w > weight) {
        				q.offer(0);
        				answer++;
        			}else {
        				q.offer(w);
        				max += w;
        				answer++;
        				System.out.println("max : " + max + "   w : " + w );
        				break;
        			}
        		}
        	}
        }
        
        return answer + bridge_length;
    }
}
