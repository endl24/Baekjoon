import java.util.*;
import java.io.*;

public class Main {
	static final long MOD = 1000000007L;
	static long count;
	public static long power(long base, long exponent) {
		long result = 1;
		
		while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }
            
            base = (base * base) % MOD;
            exponent /= 2;
        }
		
		return result;
	}
	public static void main(String args[]) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(br.readLine());
        //N = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++) {
        	count = 0;
        	long n = Long.parseLong(br.readLine());
        	if(n==1) {
        		bw.write(1+"\n");
        	}else {
            	bw.write(power(2,n-2)+"\n");
        	}
        }
        bw.flush();
        bw.close();
	}
}