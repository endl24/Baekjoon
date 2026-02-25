import java.util.*;
import java.io.*;

public class Main {
	static int n,m;
	static boolean [][] graph;
	static boolean [] visited;
	static int cnt=0;
	public static void dfs(int v) {
		if(visited[v]) {
			return;
		}
		visited[v]=true;
		for(int i=1;i<=n;i++) {
			if(graph[v][i] && !visited[i]) {
				dfs(i);
			}
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new boolean[n+1][n+1];
        visited = new boolean[n+1];
        m = Integer.parseInt(st.nextToken());
        for(int i=0;i<m;i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	graph[x][y] = true;
        	graph[y][x] = true;
        }
        for(int i=1;i<=n;i++) {
        	if (!visited[i]) {
                dfs(i); 
                cnt++; 
            }
        }
        System.out.print(cnt);
	}
}