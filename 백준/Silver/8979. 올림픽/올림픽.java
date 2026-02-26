import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n][4];
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<4;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
        }
        Arrays.sort(arr, (s1, s2) ->{
        	if (s1[1] != s2[1]) return s2[1] - s1[1];
        	if (s1[2] != s2[2]) return s2[2] - s1[2];
        	if (s1[3] != s2[3]) return s2[3] - s1[3];
        	return s1[0] - s2[0];
        });
        int rank []= new int[n+1];
        for(int i=0;i<n;i++) {
        	if(i>0 && arr[i][1] == arr[i-1][1] && arr[i][2] == arr[i-1][2] && arr[i][3] == arr[i-1][3]) {
				rank[arr[i][0]] = rank[arr[i-1][0]];
			} else {
				rank[arr[i][0]] = i+1;
			}
        }
        bw.write(rank[k] + "\n");
        bw.flush();
    }
}