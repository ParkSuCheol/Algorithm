package Mar;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_PG_KAKAO_Ä«Ä«¿ÀÇÁ·»ÁîÄÃ·¯¸µºÏ {
	public static void main(String[] args) {
		int[][] arr = {{1,1,1,0}, {1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
//		solution(6,4,arr);
	}

	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };
	static int[][] picture;
	static boolean[][] visited;

	public int[] solution(int m, int n, int[][] picture) {

		visited = new boolean[m][n];
		this.picture = picture;
		int[] answer = bfs(m, n);
		System.out.println(answer[0]);
		
		return answer;
	}

	static int[] bfs(int m, int n) {
		int[] answer = new int[2];
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int count = 0;
				if (picture[i][j] != 0 && !visited[i][j]) {
					q.add(new Point(i,j));
					visited[i][j] =true;
					count++;
					answer[0]++;
				}
				while(!q.isEmpty()) {
					Point p = q.poll();
					int x = p.x;
					int y = p.y;
					
					for(int k = 0; k < 4; k++) {
						int fx = x+dx[k];
						int fy = y+dy[k];
						if(fx < 0 || fx >= m || fy < 0 || fy >= n || visited[fx][fy] || picture[x][y] != picture[fx][fy])
							continue;
						else {
							q.add(new Point(fx,fy));
							visited[fx][fy] = true;
							count++;
						}
					}
					answer[1] = Math.max(count, answer[1]);
				}
			}
		}
		return answer;
	}
	
	static class Point{
		int x;
		int y;
		Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	

}
