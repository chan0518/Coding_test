import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static HashMap<Integer, List<Integer>> hm = new HashMap<>();
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	dp = new int[N+1];
    	dp[1] = 1;
    	
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int b = Integer.parseInt(st.nextToken());
    		int a = Integer.parseInt(st.nextToken());
    		if(hm.get(a) == null) hm.put(a, new ArrayList<>());
    		hm.get(a).add(b);
    	} // 입력완료
    	
    	for(int i=2; i<=N; i++) {
    		if(hm.containsKey(i)) {
    			for(int j=0; j<hm.get(i).size(); j++) {
    				dp[i] = Math.max(dp[i], dp[hm.get(i).get(j)] + 1);
    			}
    		}
    		else {
    			dp[i] = 1;
    		}
    	}
    	for(int i=1; i<=N; i++) System.out.print(dp[i] + " ");
    }
}