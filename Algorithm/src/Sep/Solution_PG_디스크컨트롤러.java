package Sep;
import java.util.*;
public class Solution_PG_디스크컨트롤러 {
	public static void main(String[] args) {
		int[][] jobs = {{0,3},{1,9},{2,6}};
		solution(jobs);
	}
	public static int solution(int[][] jobs) {
        int answer = 0;
        int count = 0; // 처리 된 디스크
        int now = 0; // 작업이 끝난시간
        Arrays.sort(jobs,((o1,o2)->(o1[0]-o2[0])));
        PriorityQueue<int[]> q = new PriorityQueue<>(((o1,o2)->o1[1]-o2[1]));
        int i = 0;
        while(count < jobs.length) {
        	while(i < jobs.length && jobs[i][0] <= now) {
        		q.add(jobs[i++]);
        	}
        	if(q.isEmpty()) {
        		now = jobs[i][0];
        	}else {
        		int[] tmp = q.poll();
        		answer += tmp[1] + now - tmp[0];
        		now += tmp[1];
        		count++;
        	}
        }
        return answer/jobs.length;
    }
}
