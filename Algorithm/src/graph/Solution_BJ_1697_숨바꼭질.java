package graph;

import java.util.*;

public class Solution_BJ_1697_숨바꼭질 {
	 static Scanner scan = new Scanner(System.in);
	    static StringBuilder sb = new StringBuilder();

	    static int N, K;
	    static int[] dist;
	    static boolean[] visit;

	    static void input() {
	        N = scan.nextInt();
	        K = scan.nextInt();
	        visit = new boolean[100005];
	        dist = new int[100005];
	    }

	    // 숨바꼭질 시작~
	    static void bfs() {
	        Queue<Integer> Q = new LinkedList<>();
	        Q.add(N);
	        visit[N] = true;
	        dist[N] = 0;
	        
	        // BFS 과정 시작
	        while(!Q.isEmpty()) {
	        	int x = Q.poll();
	        	int y = x - 1;
	        	if(0 <= y && y <= 100000 && !visit[y]) {
	        		visit[y] = true;
	        		dist[y] = dist[x]+1;
	        		Q.add(y);
	        	}
	        	y = x + 1;
	        	if(0 <= y && y <= 100000 && !visit[y]) {
	        		visit[y] = true;
	        		dist[y] = dist[x]+1;
	        		Q.add(y);
	        	}
	        	y = x * 2;
	        	if(0 <= y && y <= 100000 && !visit[y]) {
	        		visit[y] = true;
	        		dist[y] = dist[x]+1;
	        		Q.add(y);
	        	}
	        }
	    }

	    static void pro() {
	        bfs();
	        System.out.println(dist[K]);
	    }

	    public static void main(String[] args) {
	        input();
	        pro();
	    }

}
