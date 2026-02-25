import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

		int sumList[]=new int [n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			int num = Integer.parseInt(st.nextToken());
			sumList[i]=sumList[i-1]+num;
			
		}
		StringBuilder sb = new StringBuilder();
		for(int k=0;k<m;k++) {
			st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int result = sumList[j] - sumList[i-1];
            sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}