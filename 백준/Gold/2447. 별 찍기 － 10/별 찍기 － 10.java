import java.util.*;
import java.io.*;

public class Main {
	public static String kanto(int n) {
		if(n==1) {
			return "-";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(kanto(n/3));
		for(int i=0;i<n/3;i++) {
			sb.append(" ");
		}
		sb.append(kanto(n/3));
		return sb.toString();
	}
	public static String[] Star(int n) {
		if(n==1) {
			return new String[] {"*"};
		}
		String[] mini = Star(n/3);
		
		String[] star = new String[n];
		int subsize = n/3;
		for(int i=0;i<subsize;i++) {
			String s = mini[i];
			star[i] = s+s+s;
			String space = " ".repeat(subsize); 
            star[i + subsize] = s + space + s;
            star[i+subsize*2] = s+s+s;
		}
		return star;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String star[]=Star(n);
		StringBuilder sb = new StringBuilder();
        for (String line : star) {
            sb.append(line).append('\n');
        }
		System.out.print(sb);
	}
}