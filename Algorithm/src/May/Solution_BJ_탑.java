package May;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_BJ_ž {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(n);
		Stack<Top> stack = new Stack<>();
		
		for(int i = 1; i <= n; i++) {
			int height = Integer.parseInt(st.nextToken());
		
			if(stack.isEmpty()) {
				sb.append("0 ");
				stack.push(new Top(i,height));
			}else {
				while(true) {
					if(stack.isEmpty()) {
						sb.append("0 ");
						stack.push(new Top(i,height));
						break;
					}
					
					Top top = stack.peek();
					if(top.height > height) {
						sb.append(top.num + " ");
						stack.push(new Top(i,height));
						break;
					}else {
						stack.pop();
					}
				}
			}
		}
		System.out.println(sb);
	}
}

class Top{
	int num;
	int height;
	
	Top(int num, int height){
		this.num = num;
		this.height = height;
	}
}
