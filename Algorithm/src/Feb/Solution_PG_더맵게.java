package Feb;

import java.util.PriorityQueue;

public class Solution_PG_´õ¸Ê°Ô {
	public static void main(String[] args) {
		int arr[] = { 0, 0 };
		System.out.print(solution(arr, 7));
	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> heap = new PriorityQueue();
		for (int i : scoville) {
			heap.add(i);
		}

		while (heap.peek() <= K) {
			if (heap.size() == 1) {
				return -1;
			}
			int a = heap.poll();
			int b = heap.poll();
			int res = a + (b * 2);
			heap.add(res);
			answer++;
			System.out.println(heap);
		}
		return answer;
	}
}
