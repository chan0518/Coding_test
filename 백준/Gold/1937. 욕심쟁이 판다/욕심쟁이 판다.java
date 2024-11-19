import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static int[][] dp;
	static int[][] D = {
			{-1, 0},	// 상
			{1, 0},		// 하
			{0, -1},	// 좌
			{0, 1},		// 우
	};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		dp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력완료
		
		
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				max = Math.max(max, dfs(i,j));
			}
		}
		System.out.println(max);
		
		//for(int[] e1: dp) System.out.println(Arrays.toString(e1));
	}	
	
	static int dfs(int x, int y) {
		if(dp[x][y] != 0) return dp[x][y];
		dp[x][y] = 1;
		
		for(int i=0; i<4; i++) {
			int nx = x + D[i][0];
			int ny = y + D[i][1];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if(map[x][y] < map[nx][ny]) dp[x][y] = Math.max(dp[x][y], dfs(nx,ny) + 1);
//			if(map[x][y] < map[nx][ny]) dp[x][y] = dfs(nx,ny) + 1;
			
		}
		return dp[x][y];
	}
}
