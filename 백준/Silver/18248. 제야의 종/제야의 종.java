import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int hear[][] = new int [n][m];
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<m;j++) {
        		hear[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        Arrays.sort(hear,(a,b)->{
        	int sumA = 0;
            int sumB = 0;
            for (int i = 0; i < m; i++) {
                sumA += a[i];
                sumB += b[i];
            }
            return sumB - sumA;
        });
        for(int i=0;i<m;i++) {
        	boolean flag = true;
        	for(int j=0;j<n;j++) {
        		if(hear[j][i]==0) {
        			flag = false;
        		}else {
        			if(flag==false) {
        				System.out.print("NO");
        				return;
        			}
        		}
        	}
        }
        System.out.print("YES");
        return;
	}
}