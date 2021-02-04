package Feb;

import java.util.Arrays;

public class Solution_PG_주식가격_스택_큐 {
	    public static int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        
	        for(int i = 0; i < prices.length; i++){
	            for(int j = i + 1; j < prices.length; j++){
	                if(prices[i] > prices[j]){
	                    answer[i] = j - i;
	                    break;
	                }
	                if(j == prices.length - 1)
	                    answer[i] = j - i;
	            }
	        }
	        
	        return answer;
	    }
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,2,3};
		System.out.println(Arrays.toString(solution(arr)));
	}
}
