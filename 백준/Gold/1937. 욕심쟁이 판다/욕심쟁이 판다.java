import java.io.*;
import java.util.*;

public class Main {
    static int n, max;
    static int[][] map, dp;
    static int[][] D = {
        {-1, 0},    // 상
        {1, 0},     // 하
        {0, -1},    // 좌
        {0, 1},     // 우
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }// 입력 완료
        
        max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }
        System.out.println(max);
    }
    
    static int dfs(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y]; // 이미 계산된 경우
        dp[x][y] = 1;
        
        for(int[] d : D) {
        	int nx = x + d[0];
        	int ny = y + d[1];
        	
        	if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
        	
        	if (map[x][y] < map[nx][ny]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
            }
        }
        return dp[x][y];
    }
}
