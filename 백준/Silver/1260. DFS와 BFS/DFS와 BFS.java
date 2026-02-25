import java.util.*;
import java.io.*;

public class Main {
	static final int MAX_VERTICES = 1001;
	
	static class Graph{
		int n;
		int[][] adjMatrix;
		boolean[] visited;
		
		public Graph(int n) {
			this.n = n;
			adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
			visited = new boolean[MAX_VERTICES];
		}
		public void insertVertex(Graph g, int v) {
			g.n++;
		}
		public void insertEdge(Graph g, int start, int end) {
			g.adjMatrix[start][end] = 1;
			g.adjMatrix[end][start] = 1;
		}
		public void DFS(Graph g, int v) {
			g.visited[v] = true;
			System.out.print(v + " ");
			for(int i=1;i<=g.n;i++) {
				if(g.adjMatrix[v][i] == 1 && !g.visited[i]) {
					DFS(g, i);
				}
			}
		}
		public void BFS(Graph g, int v) {
			Queue<Integer> queue = new LinkedList<>();
			g.visited[v] = true;
			queue.offer(v);
			while(!queue.isEmpty()) {
				int curr = queue.poll();
				System.out.print(curr + " ");
				for(int i=1;i<=g.n;i++) {
					if(g.adjMatrix[curr][i] == 1 && !g.visited[i]) {
						g.visited[i] = true;
						queue.offer(i);
					}
				}
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		Graph g = new Graph(n);
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			g.insertEdge(g, a, b);
		}
		g.DFS(g, v);
		System.out.println();
		Arrays.fill(g.visited, false);
		g.BFS(g, v);
	}
}