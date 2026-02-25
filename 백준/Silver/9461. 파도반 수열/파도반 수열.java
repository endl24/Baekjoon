import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt=0;
        int max=0;
        long [] dp = new long [101];
        dp[1]=1;
        dp[2]=1;
        dp[3]=1;
        int t = Integer.parseInt(br.readLine());
        int test[] = new int [t];
        for(int i=0;i<t;i++) {
        	test[i] = Integer.parseInt(br.readLine());
        	if(max<test[i]) {
        		max=test[i];
        	}
        }
        for(int i=4;i<=max;i++) {
        	dp[i]=dp[i-2]+dp[i-3];
        }
        for(int i=0;i<t;i++) {
        	bw.append(dp[test[i]]+"\n");
        }
        bw.flush();
	}
}