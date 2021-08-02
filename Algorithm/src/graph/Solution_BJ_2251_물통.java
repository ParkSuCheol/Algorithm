package graph;

import java.util.*;

public class Solution_BJ_2251_���� {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	static int[] Limit;
	static boolean[] possible;
	static boolean[][][] visit;


	public static void main(String[] args) {
		input();
		pro();
	}

	static void input() {
		Limit = new int[3];
		for (int i = 0; i < 3; i++)
			Limit[i] = sc.nextInt();
		visit = new boolean[205][205][205];
		possible = new boolean[205];
	}
	
	// ���� Ž�� ����
	static void bfs(int x1, int x2, int x3) {
		Queue<State> Q = new LinkedList<>();
		visit[x1][x2][x3] = true;
		Q.add(new State(new int[] {x1,x2,x3}));
		
		//BFS ���� ����
		while(!Q.isEmpty()) {
			State st = Q.poll();
			if(st.X[0] == 0) possible[st.X[2]] =true;
			for(int from = 0; from <3; from++) {
				for(int to = 0; to< 3; to++) {
					if(from == to) continue;
					State nxt = st.move(from, to, Limit);
					
					if(!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
						visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
						Q.add(nxt);
					}
				}
			}
		}
	}

	static void pro() {
		bfs(0, 0, Limit[2]);
		// ���� ����ϱ�
		for(int i =0 ; i <= Limit[2]; i++) {
			if(possible[i]) sb.append(i).append(' ');
		}
		System.out.println(sb);
	}

	// ������ ���� ���¿� ���� �״� ������ �����ϴ� ����ü
	public static class State {
		int[] X;

		State(int[] _X) {
			X = new int[3];
			for (int i = 0; i < 3; i++)
				X[i] = _X[i];
		}

		State move(int from, int to, int[] Limit) {
			// from ���뿡�� to �������� ���� �ű��.
			int[] nX = new int[] { X[0], X[1], X[2] };
			if(X[from] + X[to] >= Limit[to]) {
				nX[from] -= Limit[to] - X[to];
				nX[to] = Limit[to];
			}else {
				nX[to] += nX[from];
				nX[from] = 0;
			}
			return new State(nX);
		}
	}
}
