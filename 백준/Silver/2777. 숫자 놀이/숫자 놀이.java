import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
        	int n  = Integer.parseInt(br.readLine());
        	if (n == 1) {
        	    System.out.println(1);
        	    continue; 
        	}
        	int cnt = 0;
        	for(int j=9;j>1;j--) {
        		while(n%j==0) {
        			cnt++;
        			n/=j;
        		}
        	}
        	if (n > 1) {
        	    System.out.println(-1); 
        	} else {
        		System.out.println(cnt);
        	}
        }
	}
}