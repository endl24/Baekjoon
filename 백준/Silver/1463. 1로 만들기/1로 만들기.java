import java.util.*;
import java.io.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		arr[0] = 0;
		arr[1] = 0;
		for(int i=2;i<=n;i++) {
			if(i%2==0 && i%3==0) {
				arr[i] = Math.min(arr[i-1], Math.min(arr[i/2], arr[i/3]))+1;
				continue;
			}else if(i%2==0) {
				arr[i] = Math.min(arr[i-1], arr[i/2])+1;
				continue;
			}else if(i%3==0) {
				arr[i] = Math.min(arr[i-1], arr[i/3])+1;
				continue;
			}else {
				arr[i] = arr[i-1]+1;
			}
		}
		System.out.println(arr[n]);
	}
}