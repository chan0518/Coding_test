import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static BufferedReader br;
    static StringTokenizer st;
    static int[] S, B;
    static int min = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws IOException {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	S = new int[N];
    	B = new int[N];
    	
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		S[i] = Integer.parseInt(st.nextToken());
    		B[i] = Integer.parseInt(st.nextToken());
    	}//입력완료
    	bitMask();
    	System.out.println(min);
    }
    
    static void bitMask() {
    	
    	for(int allCase = 1; allCase < (1<<N); allCase++) {
    		//allCase가 0부터 시작하면 밑의 if문에 false이므로 1 - 0 으로 항상 min값이 1이 나오기때문에 1부터 시작
    		int sMul = 1, bSum = 0;
    		
    		for(int i=0; i<N; i++) {
    			if((allCase & (1<<i)) != 0) {
    				sMul *= S[i];
    				bSum += B[i];
    			}
    		}
    		int value = Math.abs(sMul - bSum);
    		min = Math.min(min, value);
    	}
    }
}