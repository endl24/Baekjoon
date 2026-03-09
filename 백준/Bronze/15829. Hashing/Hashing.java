import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(br.readLine());
        long hash = 0;
        long m = 1234567891;
        long r = 1;
        String s = br.readLine();
        for(int i=0;i<l;i++) {
        	char c = s.charAt(i);
        	hash += (c- 'a'+1)*r % m;
        	r = (r * 31) % m;
        }
        System.out.print(hash);
    }
}