package Feb;

import java.util.*;

public class Solution_PG_KAKAO_�������� {
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
			// �迭�� ���鼭 hashMap�� ���ٸ� ���� �߰����ְ�
        	// �ִٸ� ������ �ϳ� �߰����ش�
        	if(!hm.containsKey(gems[i]))
        		hm.put(gems[i], 1);
        	else
        		hm.put(gems[i], hm.get(gems[i])+1);
        	
        	// ť�� ������ ����ش�.
        	q.add(gems[i]);
        	
        	//ť�� ù���� ������ ������ 1���� �ʰ��Ѵٸ� startPoint �� �������ְ� q���� ���ش�
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
        	// ���� ���� ť�� �ִ� ������ ��� ������ �����ϰ� hm�� ũ��� hs�� ũ�Ⱑ ���ٸ�
        	// ���α��� ������ ���� ������ ���̺��� �۴ٸ� ���� ��������Ʈ ���� start�� �������ش�
        	
        	if(hm.size() == hs.size() && length > q.size()) {
        		length = q.size();
        		start = startPoint;
        	}
        	
		}
        return new int[] {start+1,start+length};
    }
}
