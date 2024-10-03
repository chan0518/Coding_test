import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, K, result;
    static int[] dp;
    static int[][] vc;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
        	sb.append("#").append(test_case).append(" ");
            sol(test_case);
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    private static void sol(int tc) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K+1];// 0~K중량까지
        vc = new int[N][2];// 부피, 가치
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            vc[i][0] = Integer.parseInt(st.nextToken());
            vc[i][1] = Integer.parseInt(st.nextToken());
        }
        result = maxValue();
    }
    
    private static int maxValue() {
		for (int[] e : vc) {
			for (int i = K; i > 0; i--) {
				int v = e[0];
				int c = e[1];
				if (v <= i) dp[i] = Math.max(dp[i-v] + c, dp[i]);
			}
		}
		return dp[K];
	}
}