import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        int b[] = new int[n];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	while(st.hasMoreTokens()) {
			for(int i=0; i<n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
		}
    	st = new StringTokenizer(br.readLine());
    	while(st.hasMoreTokens()) {
    		for(int i=0; i<n; i++) {
    			b[i] = Integer.parseInt(st.nextToken());
    		}
    	}
    	Arrays.sort(a);
    	Arrays.sort(b);
    	int reverse[] = new int[n];
    	for(int i=0; i<n; i++) {
			reverse[i] = b[n-1-i];
		}
    	int sum =0;
    	for(int i=0; i<n; i++) {
			sum += a[i]*reverse[i];
		}
    	bw.write(sum+"");
		bw.flush();
		bw.close();
		br.close();
    }
}