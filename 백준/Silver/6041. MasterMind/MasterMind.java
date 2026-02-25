import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	static class Code{
		String num;
		int correct;
		int incorrect;
		
		Code(String num, int correct, int incorrect){
			this.num=num;
			this.correct=correct;
			this.incorrect=incorrect;
		}
	}
	static boolean check(String tmpNum, List<Code> records) {
		for(Code c:records) {
			int correct = 0;
            int incorrect = 0;
            
            for(int i=0;i<4;i++) {
            	if(tmpNum.charAt(i) == c.num.charAt(i)) {
            		correct++;
            	}
            }
            if(correct != c.correct) {return false;}
            
            int[] candCnt = new int[10]; 
            int[] guessCnt = new int[10];
            
            for (int j=0;j<4;j++) {
                candCnt[tmpNum.charAt(j) - '0']++;
                guessCnt[c.num.charAt(j) - '0']++;
            }
            
            int totalMatch = 0;
            for (int j = 0; j < 10; j++) {
                totalMatch += Math.min(candCnt[j], guessCnt[j]);
            }
            incorrect = totalMatch - correct;
            if(incorrect!=c.incorrect) {
            	return false;
            }
		}
		return true;
	}
	public static void main(String args[]) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Code> records = new ArrayList<>();
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	String num = st.nextToken();
        	int correct = Integer.parseInt(st.nextToken());
        	int incorrect = Integer.parseInt(st.nextToken());
        	records.add(new Code(num, correct, incorrect));
        }
        for(int i=1000;i<=9999;i++) {
        	String guess = String.valueOf(i);
        	
        	if (check(guess, records)) {
                System.out.println(guess);
                return;
            }
        }
        System.out.println("NONE");
	}
}