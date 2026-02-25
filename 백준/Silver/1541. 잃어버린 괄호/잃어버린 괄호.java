import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String line = sc.next();
		String [] part = line.split("-");
		int res=0;
		for(int i=0;i<part.length;i++) {
			int sum=0;
			String[] add=part[i].split("\\+");
			for(String n:add) {
				sum+=Integer.parseInt(n);
			}
			if(i==0) {
				res+=sum;
			}else {
				res-=sum;
			}
		}
		System.out.print(res);
	}
}