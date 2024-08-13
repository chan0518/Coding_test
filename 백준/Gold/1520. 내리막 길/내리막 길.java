import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] board;
    static int[][] dp;
    static int[][] D = {	{1,0},
    							{-1,0},
    							{0,1},
    							{0,-1}	};

    static void dfs(int y, int x){
        if(y== m-1 & x==n-1){
            dp[y][x] = 1;
            return;
        }
        if(dp[y][x] != -1)
            return;
        
        dp[y][x] = 0;
        for(int[] d: D){
            int next_x = x+d[1];
            int next_y = y+d[0];

            if(next_x < n & next_x>=0 & next_y < m & next_y>=0){
                if(board[y][x] > board[next_y][next_x]){
                    dfs(next_y, next_x);
                    dp[y][x] += dp[next_y][next_x];
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.valueOf(st.nextToken());
        n = Integer.valueOf(st.nextToken());
        board = new int[m][n];
        dp = new int[m][n];

        for(int i=0; i<m;i++) {
        	st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.valueOf(st.nextToken());
                dp[i][j] = -1;
            }
        }

        dfs(0, 0);

        System.out.println(dp[0][0]);
    }
    
}