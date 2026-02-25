import java.util.*;
import java.io.*;

public class Main {
	static int shiro = 0;
	static int ao = 0;
	public static int isSame(boolean [][] p, int n, int row, int col) {
		int flag;
		if(p[row][col]) {
			flag=1;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(!p[row + i][col + j]) {
	                    return 0; 
	                }
				}
			}
		} else {
			flag=2;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(p[row + i][col + j]) {
	                    return 0; 
	                }
				}
			}
		}
		return flag;
	}
	public static void paper(boolean [][] p, int n, int row, int col) {
		int flag;
		if(n==1) {
			if(p[row][col]) {
				ao++;
			}else {
				shiro++;
			}
		}
		else {
			flag = isSame(p, n, row, col);
			if(flag==0) {
				paper(p, n/2, row, col);
				paper(p, n/2, row, col+n/2);
				paper(p, n/2, row+n/2, col);
				paper(p, n/2, row+n/2, col+n/2);
			} else if (flag==1) {
				ao++;
			} else if (flag==2) {
				shiro++;
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean [][] p = new boolean[n][n]; 
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int tmp=sc.nextInt();
				if(tmp==1) {
					p[i][j]=true;
				} else {
					p[i][j]=false;
				}
			}
		}
		paper(p, n, 0, 0);
		System.out.println(shiro);
		System.out.println(ao);
	}
}