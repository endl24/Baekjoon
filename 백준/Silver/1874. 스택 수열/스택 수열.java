import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(); 
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            int next = Integer.parseInt(br.readLine());
            
            while (next > max) {
                stack.push(++max);
                sb.append("+\n");
            }
            
            if (next <= max) {
                if (stack.peek() == next) {
                    stack.pop();
                    sb.append("-\n");
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.print(sb.toString());
    }
}