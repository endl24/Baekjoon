import java.util.*;
import java.io.*;

public class Main {
	public static long pow(long a, long b, long c) {
		if(b==1) {
			return a % c;
		}
		if(b%2==0) {
			long tmp = pow(a, b/2, c);
			return tmp*tmp%c;
		}else {
			long tmp = pow(a, b/2, c);
			return (tmp*tmp%c)*a%c;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long result = pow(a, b, c);
        bw.append(result+"");
        bw.flush();
	}
}