import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
        int[] num = new int[8001];
        Arrays.sort(arr);
        int mid = arr[n/2];
        long sum = 0;
        for(int i=0; i<n; i++) {
        	sum+=arr[i];
        	num[arr[i]+4000]++;
        }
        int avg = (int) Math.round((double)sum/n);
        int max = 0;
        int mode = -4001;
        boolean flag = false;
       
        for(int i=-4000;i<=4000;i++) {
        	if(num[i+4000]==0) {
        		continue;
        	}
        	if(max<num[i+4000]) {
        		max = num[i+4000];
        		mode = i;
        		flag=false;
        	}else if(num[i+4000] == max && !flag) {
        		mode = i;
        		flag = true;
        	}
        }
        int diff = arr[n-1] - arr[0];
        System.out.println(avg);
        System.out.println(mid);
        System.out.println(mode);
        System.out.println(diff);
    }
}