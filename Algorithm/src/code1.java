import java.util.*;
public class code1 {
	public static void main(String[] args) {
		String S = "5 6 + -";
		System.out.println(solution(S));
	}
	public static int solution(String S) {
        int answer = 0;
        String[] arr = S.split(" ");
        Stack<Integer> stack = new Stack<>();
        int tmp = 0;
        int tmp2 = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
        	if(arr[i].equals("POP")) {
        		stack.pop();
        	}else if (arr[i].equals("DUP")) {
        		tmp = stack.peek();
        		stack.add(tmp);
        	}else if (arr[i].equals("+")) {
        		if(stack.size() < 2)
        			return -1;
        		tmp = stack.pop();
        		tmp2 = stack.pop();
        		res = tmp + tmp2;
        		stack.add(res);
        	}else if (arr[i].equals("-")) {
        		if(stack.size() < 2)
        			return -1;
        		tmp = stack.pop();
        		tmp2 = stack.pop();
        		res = tmp - tmp2;
        		stack.add(res);
        	}else {
        		tmp = Integer.parseInt(arr[i]);
        		stack.add(tmp);
        	}
		}
        answer = stack.pop();
        return answer;
    }
}
