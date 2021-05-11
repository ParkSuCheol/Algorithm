package May;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_BJ_��ū�� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Stack<Integer> stack = new Stack<Integer>();
		int[] seq = new int[N];
		
		for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			/*
			 * ������ ������� �����鼭
			 * ���� ���Ұ� ������ �� �� ���Ұ� ����Ű�� ���Һ��� ū ���
			 * �ش� ������ ������ �� ���� stack�� ���Ҹ� pop�ϸ鼭
			 * �ش� �ε����� ���� ���� ���ҷ� �ٲ��ش�.
			 */
			while(!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
				seq[stack.pop()] = seq[i];
			}
			stack.push(i);
		}
		/*
		 * ������ ��� ���Ҹ� pop �ϸ鼭 �ش� �ε����� value��
		 * -1�� �ʱ�ȭ ���ش�
		 */
		while(!stack.isEmpty()) {
			seq[stack.pop()] = -1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i ++) {
			sb.append(seq[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
