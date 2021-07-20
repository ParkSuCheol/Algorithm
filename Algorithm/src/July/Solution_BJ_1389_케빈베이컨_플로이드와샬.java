package July;
import java.util.*;
public class Solution_BJ_1389_케빈베이컨_플로이드와샬 {
	public static void main(String[] args) {
		input();
		pro();
	}
	static int N,M;
	static int[] answerNum;
	static int[] minDis;
	static int[][] dist;
	static int INF = 5001;
	public static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		dist = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i == j) dist[i][j] = 0;
				else dist[i][j] = INF;
			}
		}
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			dist[start][end] = 1;
			dist[end][start] = 1;
		}
	}
	public static void pro() {
		floyd();
		int[] answer = new int[N+1];
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += dist[i][j];
			}
			answer[i] = sum;
			if(sum < min) {
				min = sum;
			}
		}
		for(int i = 1; i <= N; i++) {
			if(answer[i] == min) {
				System.out.println(i);
				return;
			}
		}
	}
	public static void floyd() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
				}
			}
		}
	}
}
