import java.util.*;
import java.io.*;

public class Main {
	static boolean [] visited;
	static ArrayList<Integer> [] arr;
	static int count = 1;
	public static void dfs(int a) {
		visited[a] = true;
		for(int i:arr[a]) {
			if(!visited[i]) {
				count++;
				dfs(i);
			}
		}
	}
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	arr[a].add(b);
        	arr[b].add(a);
        }
        long set = 1;
		for(int i=1;i<=n;i++) {
			count = 1;
			if(!visited[i]) {
				dfs(i);
				set = (set*count)%1000000007;
			}
		}
		bw.write(set+"");
		bw.flush();
    }
}