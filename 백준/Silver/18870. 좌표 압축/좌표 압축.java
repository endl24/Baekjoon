import java.util.*;
import java.io.*;

public class Main {
	
	public static class Point{
		int x;
		int idx;
		int comp;
		Point(int x, int idx){
			this.x = x;
			this.idx = idx;
			this.comp = -1;
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Point xArr[] = new Point[n];
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			xArr[i] = new Point(x, i);
		}
		Arrays.sort(xArr, (a, b) -> Integer.compare(a.x, b.x));
		for(int i=0; i<n; i++) {
			if(i == 0) {
				xArr[i].comp = 0;
			} else {
				if(xArr[i].x == xArr[i-1].x) {
					xArr[i].comp = xArr[i-1].comp;
				} else {
					xArr[i].comp = xArr[i-1].comp + 1;
				}
			}
		}
		Arrays.sort(xArr, (a, b) -> Integer.compare(a.idx, b.idx));
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
		    sb.append(xArr[i].comp).append(" ");
		}
		System.out.println(sb); 
	}
}