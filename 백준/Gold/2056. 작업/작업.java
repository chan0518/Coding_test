import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer>[] arr;
	
    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        for(int i=0; i<=N; i++) arr[i] = new ArrayList<>();
        
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i].add(Integer.parseInt(st.nextToken()));
        	arr[i].add(Integer.parseInt(st.nextToken()));
        	for(int j=0; j<arr[i].get(1); j++) {
        		arr[i].add(Integer.parseInt(st.nextToken()));
        	}
        }// 입력 완료
        
        int[] dp = new int[N+1]; // 1~N
        dp[1] = arr[1].get(0);
        
        for(int i=2; i<=N; i++) {
        	int num = arr[i].get(0);
        	int max = 0;
        	for(int j=0; j<arr[i].get(1); j++) {
        		max = Math.max(max, dp[arr[i].get(j+2)]);
        	}
        	num += max;
        	dp[i] = num;
        }
        
        Arrays.sort(dp);
        System.out.println(dp[dp.length-1]);
    }
    
}