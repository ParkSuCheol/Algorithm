package July;

import java.util.*;

public class Solution_BJ_2644_촌수계산_bfs_dist활용 {
	public static void main(String[] args) {
		input();
		pro();
	}
	
	public static class Person{
		int num;
		int cnt;
		public Person(int num, int cnt){
			this.num = num;
			this.cnt = cnt;
		}
	}

	static int N, Gx, Gy, X, Y, M;
	static int[][] map;
	static boolean[] v;
	public static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		v = new boolean[N+1];
		Gx = sc.nextInt();
		Gy = sc.nextInt();
		M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[b][a] = 1;
		}
	}
	public static void pro() {
		bfs(Gx,Gy);
	}
	public static void bfs(int start, int end) {
		boolean isFind = false;
		Queue<Person> q = new LinkedList<>();
		q.add(new Person(start,0));
		while(!q.isEmpty()) {
			Person person = q.poll();
			int start2 = person.num;
			if(start2 == end) {
				isFind = true;
				System.out.println(person.cnt);
				break;
			}
			for (int i = 1; i <= N; i++) {
				if(!v[i] && map[start2][i] == 1) {
					v[i] = true;
					q.add(new Person(i,person.cnt + 1));
				}
			}
		}
		if(!isFind)
			System.out.println(-1);
	}
	
}
