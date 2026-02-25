import java.util.*;
import java.io.*;

public class Main {
	static int com;
	static boolean [][] net;
	static boolean [] virus;
	static int cnt=0;
	public static void v3(int v) {
		virus[v]=true;
		cnt++;
		for(int i=1;i<=com;i++) {
			if(net[v][i] && !virus[i]) {
				v3(i);
			}
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        com = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        net = new boolean [com+1][com+1];
        for(int i=0;i<pair;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	net[x][y]=true;
        	net[y][x]=true;
        }
        virus = new boolean[com+1];
        v3(1);
        System.out.print(cnt-1);
	}
}