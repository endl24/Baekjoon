import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void hanoi(int n, int start, int mid, int to){
		if(n==1) {
			sb.append(start).append(" ").append(to).append('\n');
			return;
		}
		hanoi(n-1, start, to, mid);
		sb.append(start).append(" ").append(to).append('\n');
		hanoi(n-1, mid, start, to);
	}
	public static void main(String args[]) throws IOException {
		//Scanner sc = new Scanner(System.in);
		//int n = sc.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
		
        BigInteger count = new BigInteger("2").pow(n).subtract(BigInteger.ONE);
        System.out.println(count);
        
        if (n <= 20) {
            hanoi(n, 1, 2, 3); 
            System.out.println(sb);
        }
	}
}