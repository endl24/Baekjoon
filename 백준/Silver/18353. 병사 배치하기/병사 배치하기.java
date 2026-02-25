import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int [] unit = new int[n];
        st = new StringTokenizer(br.readLine());
        int index=0;
        while(st.hasMoreTokens()) {
        	unit[index]= Integer.parseInt(st.nextToken());
        	index++;
        }
        int [] dp = new int[n];
        for(int i=0;i<n;i++) {
        	dp[i]=1;
        	for(int j=0;j<i;j++) {
        		if(unit[j]>unit[i]) {
        			dp[i]=Math.max(dp[i], dp[j]+1);
        		}
        	}
        }
        int max = dp[0];
        for(int num:dp) {
        	if(num>max) {
        		max=num;
        	}
        }
        System.out.println(n-max);
	}
}