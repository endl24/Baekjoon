import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        
        for(int i=1;i<=t;i++) {
        	int set=0;
        	st = new StringTokenizer(br.readLine());
        	Long n = Long.parseLong(st.nextToken());
        	String bit = Long.toBinaryString(n);
        	int len = bit.length();
        	long a = (1L << (len - 1)) - 1;
        	long b = n - a;
        	if (Long.bitCount(n) == len) {
                bw.append("Case #"+i+": "+len+"\n"); 
            } else {
            	bw.append("Case #"+i+": "+((len - 1) + Long.bitCount(b))+"\n");
            }
        }
        bw.flush();
	}
}