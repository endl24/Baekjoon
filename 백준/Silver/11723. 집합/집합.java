import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int set=0;
        for(int i=0;i<m;i++) {
        	st = new StringTokenizer(br.readLine());
        	String cmd = st.nextToken();
        	if(cmd.equals("add")) {
        		int n=Integer.parseInt(st.nextToken());
        		set = set | (1<<n);
        	}else if(cmd.equals("remove")) {
        		int n=Integer.parseInt(st.nextToken());
        		set = set & ~(1<<n);
        	}else if(cmd.equals("check")) {
        		int n=Integer.parseInt(st.nextToken());
        		if((set&(1<<n))!=0) {
        			bw.append(1+"\n");
        		}else {
        			bw.append(0+"\n");
        		}
        	}else if(cmd.equals("toggle")) {
        		int n=Integer.parseInt(st.nextToken());
        		set = set ^ (1<<n);
        	}else if(cmd.equals("all")) {
        		set = (1<<21)-1;
        	}else if(cmd.equals("empty")) {
        		set = 0;
        	}
        }
        bw.flush();
	}
}