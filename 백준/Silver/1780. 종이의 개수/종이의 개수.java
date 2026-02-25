import java.util.*;
import java.io.*;

public class Main {
	static int minus = 0;
	static int zero = 0;
	static int one = 0;
	public static void paper(int arr[][], int size, int startR, int startC) {
		if(isAllSame(arr, size, startR, startC)) {
			int target = arr[startR][startC];
			if(target==-1) {
				minus++;
			}else if(target==0) {
				zero++;
			}else if(target==1) {
				one++;
			}
		}else{
			int next=size/3;
			paper(arr, next, startR, startC);
			paper(arr, next, startR, startC+next);
			paper(arr, next, startR, startC+next*2);
			paper(arr, next, startR+next, startC);
			paper(arr, next, startR+next, startC+next);
			paper(arr, next, startR+next, startC+next*2);
			paper(arr, next, startR+next*2, startC);
			paper(arr, next, startR+next*2, startC+next);
			paper(arr, next, startR+next*2, startC+next*2);
		}
	}
	public static boolean isAllSame(int arr[][], int size, int startR, int startC) {
		int first=arr[startR][startC];
		for(int i=startR;i<startR+size;i++) {
			for(int j=startC;j<startC+size;j++) {
				if(arr[i][j]!=first) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String args[]) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int [][] arr = new int[n][n];
        for(int i=0;i<n;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0;j<n;j++) {
        		arr[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        paper(arr, n, 0, 0);
        bw.append(minus+"\n"+zero+"\n"+one);
        bw.flush();
	}
}