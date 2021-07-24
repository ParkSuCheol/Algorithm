package July;
import java.util.*;
import java.io.*;
public class Solution_BJ_16235_나무재테크 {
	public static class Tree implements Comparable<Tree>{
		int x;
		int y;
		int age;
		
		Tree(int x,int y,int age){
			this.x = x;
			this.y = y;
			this.age = age;
		}
		
		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}
	static int M,N,K;
	static int[][] addRc;
	static int[][] Map;
	static PriorityQueue<Tree> trees = new PriorityQueue<>();
	static ArrayList<Tree> deathtrees = new ArrayList<>();
	static ArrayList<Tree> bread = new ArrayList<>();
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		addRc = new int[N+1][N+1];
		Map = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				addRc[i][j] = Integer.parseInt(st.nextToken());
				Map[i][j] = 5;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			trees.add(new Tree(x,y,z));
		}
		treeZetech();
		System.out.println(trees.size());
	}
	
	public static void treeZetech() {
		while(K>0) {
			treeageAdd();
			addTrees();
			addRC();
			K--;
		}
	}
	public static void treeageAdd() {
		PriorityQueue<Tree> afterTree = new PriorityQueue<>();
		int[][] chk = new int[N+1][N+1];
		while(!trees.isEmpty()) {
			Tree t = trees.poll();
			int x = t.x;
			int y = t.y;
			if(Map[x][y] >= t.age && chk[x][y] == 0) {
				Map[x][y] -= t.age;
				t.age = t.age + 1;
				if(t.age % 5 == 0) {
					bread.add(t);
				}
				afterTree.add(t);
			}else {
				if(chk[x][y] == 0) {
					chk[x][y] = 1;
					Map[x][y] += t.age / 2;
				}else {
					Map[x][y] += t.age / 2;
				}
					
			}
		}
		trees = new PriorityQueue<Tree>(afterTree);
	}
	public static void addTrees() {
		for(Tree tmp : bread) {
			for(int d = 0; d < 8; d++) {
				int x = tmp.x +dx[d];
				int y = tmp.y +dy[d];
				if(x >= 1 && y >= 1 && x <= N && y <= N) {
					trees.add(new Tree(x,y,1));
				}
			}
		}
		bread.clear();
	}
	public static void addRC() {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				Map[i][j] += addRc[i][j];
			}
		}
	}
	
}
