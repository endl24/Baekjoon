import java.util.*;
import java.io.*;

public class Main {
	static int[][] tree;
	public static void main(String args[]) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        tree = new int[26][2];
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
			int parent = st.nextToken().charAt(0) - 'A';
			int left = st.nextToken().charAt(0);
			int right = st.nextToken().charAt(0);
			tree[parent][0] = (left=='.') ? -1 : left-'A';
			tree[parent][1] = (right=='.') ? -1 : right-'A';
        }
        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
        System.out.println();
	}
	public static void preorder(int node) {
		if(node == -1) return;
		System.out.print((char)(node + 'A'));
		preorder(tree[node][0]);
		preorder(tree[node][1]);
	}
	public static void inorder(int node) {
		if(node == -1) return;
		inorder(tree[node][0]);
		System.out.print((char)(node + 'A'));
		inorder(tree[node][1]);
	}	
	public static void postorder(int node) {
		if(node == -1) return;
		postorder(tree[node][0]);
		postorder(tree[node][1]);
		System.out.print((char)(node + 'A'));
	}
}