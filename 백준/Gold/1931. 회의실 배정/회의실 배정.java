import java.util.*;
import java.io.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][2];
		for(int i=0;i<n;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int a[], int b[]) {
				if(a[1] == b[1]) {
					return a[0] - b[0];
				}
				return a[1] - b[1];
			}
		});
		
		int count = 0;
		int end = 0;
		for(int i=0;i<n;i++) {
			if(arr[i][0]>=end) {
				end = arr[i][1];
				count++;
			}
		}
		System.out.print(count);
	}
}