import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int price[][];
	static boolean plant[][];
	static int ans=Integer.MAX_VALUE;
	public static void solve(int cnt, int sum) {
		if(cnt==3) {
			ans = Math.min(ans, sum);
			return;
		}
		for(int i=1;i<n-1;i++) {
			for(int j=1;j<n-1;j++) {
				if(canPlant(i, j)) {
					plant(i, j, true);
					solve(cnt+1, sum+getCost(i, j));
					plant(i, j, false);
				}
			}
		}
	}
	public static int getCost(int row, int col) {
		int cost=0;
		cost+=price[row][col];
		cost+=price[row+1][col];
		cost+=price[row-1][col];
		cost+=price[row][col+1];
		cost+=price[row][col-1];
		return cost;
	}
	public static void plant(int row, int col, boolean flag) {
			plant[row][col]=flag;
			plant[row+1][col]=flag;
			plant[row-1][col]=flag;
			plant[row][col+1]=flag;
			plant[row][col-1]=flag;
	}
	public static boolean canPlant(int row, int col) {
		if(plant[row][col]==true || plant[row+1][col]==true || plant[row-1][col]==true || plant[row][col+1]==true || plant[row][col-1]==true) {
			return false;
		}else {
			return true;
		}
	}
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        price = new int [n][n];
        plant = new boolean [n][n];
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<n;j++) {
        		price[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        solve(0, 0);
        System.out.print(ans);
    }
}